package org.teacon.xibao.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.teacon.xibao.XiBaoMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(XiBaoMod.MOD_ID)
public class XiBaoModForge {
    public XiBaoModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(XiBaoMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        IEventBus modEventBus = EventBuses.getModEventBus(XiBaoMod.MOD_ID).get();

        modEventBus.addListener(this::onInitializeClient);
    }

    public void onInitializeClient(FMLClientSetupEvent event) {
        XiBaoMod.init();
    }
}
