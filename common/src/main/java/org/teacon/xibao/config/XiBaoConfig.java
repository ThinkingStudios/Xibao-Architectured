package org.teacon.xibao.config;

import dev.architectury.platform.Platform;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.teacon.xibao.XiBaoMod;
import org.teacon.xibao.util.XibaoType;

import java.util.Random;

public class XiBaoConfig {
    public static XiBaoConfigScreen configScreen;

    public static boolean shouldPlayMusic = false;
    public static boolean tempSnow = false;
    public static Random random = new Random();

    private static XibaoType type = XiBaoConfig.getConfig().type;

    public static void switchAlbum() {
        XibaoType[] types = XibaoType.values();
        type = types[(type.ordinal() + 1) % types.length];
    }

    public static XiBaoConfigScreen getConfig() {
        if (configScreen == null) {
            AutoConfig.register(XiBaoConfigScreen.class, GsonConfigSerializer::new);
            configScreen = AutoConfig.getConfigHolder(XiBaoConfigScreen.class).getConfig();
        }
        return configScreen;
    }

    public static void saveConfig() {
        AutoConfig.getConfigHolder(getConfig().getClass()).save();
    }

    public static void setConfigScreen() {
        Platform.getMod(XiBaoMod.MOD_ID).registerConfigurationScreen(parent -> AutoConfig.getConfigScreen(XiBaoConfigScreen.class, parent).get());
    }
}
