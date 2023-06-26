package org.teacon.xibao.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import org.teacon.xibao.XiBaoMod;
import org.teacon.xibao.util.XibaoType;

@Config(name = XiBaoMod.MOD_ID)
public class XiBaoConfigScreen implements ConfigData {
    public boolean playMusic = true;
    public boolean showBackground = true;
    public boolean playSnowAnimation = false;
    public XibaoType type = XibaoType.XIBAO;
}
