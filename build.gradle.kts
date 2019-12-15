plugins {
    kotlin("jvm") version "1.3.61"
    application
}

application {
    mainClassName = "MainKt"
}

group = "org.ligi"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.vidstige:jadb:1.1.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}