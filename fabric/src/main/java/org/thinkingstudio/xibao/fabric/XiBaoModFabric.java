package org.thinkingstudio.xibao.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.thinkingstudio.xibao.XiBaoMod;

public class XiBaoModFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        XiBaoMod.init();
    }
}
