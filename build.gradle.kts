plugins {
    id("base")
//    kotlin("jvm") version "1.9.21"
}

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

tasks {
    named<Delete>("clean") {
        delete += allprojects.map { it.layout.buildDirectory }
    }
}

//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
//}
//
//tasks.test {
//    useJUnitPlatform()
//}
//kotlin {
//    jvmToolchain(17)
//}
