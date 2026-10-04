package com.lunarstarter.client.module.impl;

import com.lunarstarter.client.module.Module;

public class WaypointsModule extends Module {
    public WaypointsModule() {
        super("Waypoints", "Mark important positions in the world");
    }

    @Override
    public void onEnable() {
        System.out.println("Waypoints module enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("Waypoints module disabled");
    }
}
