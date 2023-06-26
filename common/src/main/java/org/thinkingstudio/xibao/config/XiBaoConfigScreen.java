package org.thinkingstudio.xibao.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import org.thinkingstudio.xibao.XiBaoMod;
import org.thinkingstudio.xibao.util.XiBaoType;

@Config(name = XiBaoMod.MOD_ID)
public class XiBaoConfigScreen implements ConfigData {
    public boolean playMusic = true;
    public boolean showBackground = true;
    public boolean playSnowAnimation = false;
    public XiBaoType type = XiBaoType.XIBAO;
}
