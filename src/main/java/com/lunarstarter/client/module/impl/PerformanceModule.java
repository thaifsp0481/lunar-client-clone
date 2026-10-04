package com.lunarstarter.client.module.impl;

import com.lunarstarter.client.module.Module;

public class PerformanceModule extends Module {
    public PerformanceModule() {
        super("Performance", "Boost FPS and reduce frame spikes");
    }

    @Override
    public void onEnable() {
        System.out.println("Performance module enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("Performance module disabled");
    }
}
