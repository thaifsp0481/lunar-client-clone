package com.lunarstarter.client;

import com.lunarstarter.client.config.ClientConfig;
import com.lunarstarter.client.module.Module;
import com.lunarstarter.client.module.ModuleManager;
import com.lunarstarter.client.module.impl.MinimapModule;
import com.lunarstarter.client.module.impl.PerformanceModule;
import com.lunarstarter.client.module.impl.WaypointsModule;
import com.lunarstarter.client.ui.ClientFrame;

import javax.swing.SwingUtilities;

public class Client {
    private final ModuleManager moduleManager;
    private final ClientConfig config;
    private ClientFrame frame;

    public Client() {
        this.config = new ClientConfig();
        this.moduleManager = new ModuleManager();
    }

    public void start() {
        registerDefaultModules();
        config.load();

        SwingUtilities.invokeLater(() -> {
            frame = new ClientFrame(this);
            frame.setVisible(true);
        });
    }

    private void registerDefaultModules() {
        moduleManager.register(new PerformanceModule());
        moduleManager.register(new MinimapModule());
        moduleManager.register(new WaypointsModule());
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public ClientConfig getConfig() {
        return config;
    }

    public void save() {
        config.save();
    }

    public ClientFrame getFrame() {
        return frame;
    }
}
