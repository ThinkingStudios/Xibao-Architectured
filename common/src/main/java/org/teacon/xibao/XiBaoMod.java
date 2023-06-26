package org.teacon.xibao;

import org.teacon.xibao.config.XiBaoConfig;

public class XiBaoMod {
    public static final String MOD_ID = "xibao";
    
    public static void init() {
        XiBaoConfig.setConfigScreen();
    }
}
