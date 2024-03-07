import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:" + version { kotlin })
    implementation("com.android.library:com.android.library.gradle.plugin:" + version { agp })
    implementation("org.jetbrains.compose:compose-gradle-plugin:" + version { compose })
    implementation("org.jetbrains.kotlin:kotlin-serialization:" + version { serialization })
    implementation("io.ktor.plugin:plugin:" + version { ktor })
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

fun Project.version(version: LibrariesForLibs.VersionAccessors.() -> Provider<String>): String =
    libs.versions.version().get()