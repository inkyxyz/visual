# Rockstar Client — recovered source project

Recovered from `rockstar-client.jar` as a buildable Fabric project.

## Recovered environment

- Minecraft: `1.21.4`
- Mod loader: Fabric Loader `0.16.14`
- Java: `21` (class-file version 65)
- Input namespace: Fabric intermediary
- Source mappings: Yarn `1.21.4+build.8`
- Fabric API: `0.119.4+1.21.4`
- Gradle: `8.12.1`
- Fabric Loom: `1.10.5`

Minecraft symbols were remapped to Yarn named symbols before decompilation.
Case-insensitive class-name collisions and JVM-only member collisions introduced
by obfuscation received deterministic temporary names. The main package was
normalized to `rockstar.client`; 112 module implementations, the client
singleton, module infrastructure, setting infrastructure, and their obvious
public API methods were renamed from metadata and verified behavior. Symbols
whose purpose cannot be established from bytecode keep deterministic temporary
names instead of invented original names.

## Dependencies

The Gradle build declares Fabric API, Lombok, JSR-305, Validation API, ZXing,
HttpRequest, Thumbnailator, NanoHTTPD, Netty, Reactor Netty, OkHttp and JavaFX.
The original twelve jar-in-jar dependencies are preserved verbatim under
`src/main/resources/META-INF/jars/` and remain listed in `fabric.mod.json`.
The project does not depend on the launcher's external `libraries` directory
to compile.

Build with:

```powershell
.\gradlew.bat build
```

The resulting remapped mod JAR is written to `build/libs/`.

## Verification

The final project was checked with:

```powershell
.\gradlew.bat clean build --rerun-tasks
```

The build completed successfully, including `validateAccessWidener`,
`remapJar`, and `remapSourcesJar`. The output contains all 384 non-class
resources from the input JAR, one generated refmap, all 119 configured Mixin
classes, and all 12 embedded dependency JARs. No duplicate ZIP entries remain.

`runClient` was also verified through Fabric startup, Rockstar initialization,
resource reload, sound-engine startup, and atlas creation. Warnings for absent
Sodium targets are optional-compatibility warnings. The embedded FTE SDK uses
intermediary Minecraft names and therefore warns only in Loom's named dev
runtime; client initialization continues normally.

Existing authentication, network access, and server-side access checks were
preserved; no license, authorization, HWID, or server validation bypass was
added.
