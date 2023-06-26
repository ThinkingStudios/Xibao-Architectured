package org.teacon.xibao.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.teacon.xibao.XiBaoMod;

public class XiBaoModFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        XiBaoMod.init();
    }
}
