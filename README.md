# Lunar-inspired Minecraft Client Starter

This repository is an open-source starter project inspired by the kind of tools commonly associated with premium Minecraft clients: performance tuning, HUD modules, minimap, waypoints, and a modular settings UI.

Important:
- This project is not a full copy of Lunar Client or any proprietary client.
- It is intended as a clean, extensible codebase for learning, experimentation, and building a personal Minecraft utility client.
- If you want to turn this into a real in-game Minecraft client, you would need to integrate it with the target Minecraft version and mod loader (for example Forge or Fabric) and respect the relevant licensing and distribution rules.

## Included features

- Modular architecture for client features
- Settings persistence
- HUD-style dashboard
- Performance tuning module
- Minimap module
- Waypoints module
- Swing-based interface for previewing the client shell

## Project structure

- `src/main/java/com/lunarstarter/client` — client runtime and UI
- `src/main/java/com/lunarstarter/client/module` — module system
- `src/main/java/com/lunarstarter/client/config` — configuration utilities

## Run

```bash
gradle run
```

or, if you are using a Gradle wrapper:

```bash
./gradlew run
```

## License

MIT
