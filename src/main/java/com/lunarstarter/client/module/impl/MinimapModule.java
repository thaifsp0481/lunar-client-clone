package com.lunarstarter.client.module.impl;

import com.lunarstarter.client.module.Module;

public class MinimapModule extends Module {
    public MinimapModule() {
        super("Minimap", "Shows nearby world information in a compact view");
    }

    @Override
    public void onEnable() {
        System.out.println("Minimap module enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("Minimap module disabled");
    }
}
