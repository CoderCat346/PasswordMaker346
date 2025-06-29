/F
├── .gitignore               # Git config to ignore build/ outputs, local config files, etc.
├── README.md                # Project overview, setup instructions, usage.
├── LICENSE                  # Open source license for the boilerplate (MIT).
├── FILES.md                 # This file: explains the file tree and purpose of each file.
├── build.gradle             # Top-level Gradle build config (project-level).
├── gradle.properties        # Gradle build properties (e.g., JVM args, version configs).
├── gradlew                  # Gradle wrapper script (Unix). Ensures consistent Gradle version.
├── gradlew.bat              # Gradle wrapper script (Windows).
├── settings.gradle          # Defines included modules/subprojects.
├── proguard-rules.pro       # Rules for code shrinking/obfuscation (ProGuard/R8).
│                             # Note: Used only if minifyEnabled true in build.gradle.
│                             # Add -keep rules for reflection-based libraries.
├── gradle/                  # Gradle wrapper JAR and properties.
│   └── wrapper/             # Contains gradle-wrapper.jar and gradle-wrapper.properties.
│                             # Defines which Gradle version to download.
├── app/                     # Main Android app module.
│   ├── build.gradle         # Module-level Gradle config (dependencies, plugins).
│   ├── proguard-rules.pro   # (Optional) Module-specific ProGuard rules.
│   ├── src/                 # App source code.
│   │   ├── main/            # Main source set.
│   │   │   ├── AndroidManifest.xml  # Manifest file declaring app components.
│   │   │   ├── java/        # Kotlin/Java source files.
│   │   │   │   └── your/package/    # Your app’s package.
│   │   │   │       └── MainActivity.kt # Main entry point activity.
│   │   │   ├── res/         # Resources (layouts, drawables, values, etc.).
│   │   │   │   ├── layout/  # XML layout files (if not using Compose).
│   │   │   │   ├── values/  # Colors, strings, themes, etc.