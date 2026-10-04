package com.lunarstarter.client.module;

public abstract class Module {
    private final String name;
    private final String description;
    private boolean enabled;

    protected Module(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void update() {
    }
}
