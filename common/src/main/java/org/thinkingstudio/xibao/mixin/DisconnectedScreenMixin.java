package org.thinkingstudio.xibao.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.thinkingstudio.xibao.config.XiBaoConfig;
import org.thinkingstudio.xibao.util.RenderHelper;
import org.thinkingstudio.xibao.util.SnowAnimation;

@Environment(EnvType.CLIENT)
@Mixin(DisconnectedScreen.class)
public class DisconnectedScreenMixin extends Screen {
    protected DisconnectedScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void initInject(CallbackInfo ci) {
        XiBaoConfig.shouldPlayMusic = true;
        XiBaoConfig.tempSnow = false;
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.stopMusic"),
                        button -> XiBaoConfig.shouldPlayMusic = !XiBaoConfig.shouldPlayMusic)
                .dimensions(this.width / 2 - 100, this.height - 22, 66, 20).build());
        this.addDrawableChild(ButtonWidget.builder(
                Text.translatable("gui.dropSnow"),
                button -> {
                    SnowAnimation.INSTANCE = new SnowAnimation(XiBaoConfig.random);
                    XiBaoConfig.tempSnow = !XiBaoConfig.tempSnow;
                }).dimensions(this.width / 2 - 33, this.height - 22, 66, 20).build());
        this.addDrawableChild(ButtonWidget.builder(
                        Text.translatable("gui.switchAlbum"),
                        button -> XiBaoConfig.switchAlbum())
                .dimensions(this.width / 2 + 34, this.height - 22, 66, 20).build());
        if (XiBaoConfig.getConfig().playSnowAnimation) SnowAnimation.INSTANCE = new SnowAnimation(XiBaoConfig.random);
    }

    @Inject(method = "render", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screen/Screen;render(Lnet/minecraft/client/gui/DrawContext;IIF)V"))
    private void renderInject(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (this.client == null) return;
        if (XiBaoConfig.getConfig().showBackground) {
            RenderHelper.renderStretchTexture(this.width, this.height, 225, XiBaoConfig.getConfig().type.background);
        }
        if (XiBaoConfig.getConfig().playSnowAnimation || XiBaoConfig.tempSnow) {
            SnowAnimation.INSTANCE.tick(this.width, this.height, XiBaoConfig.getConfig().type.snows);
        }
    }
}
