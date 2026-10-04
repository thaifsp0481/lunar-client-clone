package com.lunarstarter.client.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public void register(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public Module getByName(String name) {
        for (Module module : modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public void updateAll() {
        for (Module module : modules) {
            module.update();
        }
    }
}
