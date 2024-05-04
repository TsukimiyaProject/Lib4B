import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "1.8.0"
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

group = "mc.tsukimiya"
version = "1.2.0"

val mcVersion = "1.20.4"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    library(kotlin("stdlib"))
    library("org.jetbrains.exposed:exposed-core:0.41.1")
    compileOnly("io.papermc.paper:paper-api:${mcVersion}-R0.1-SNAPSHOT")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

bukkit {
    name = "Lib4B"
    version = getVersion().toString()
    description = "ライブラリ詰め合わせ"
    author = "deceitya"
    main = "mc.tsukimiya.lib4b.Lib4B"
    apiVersion = mcVersion.substring(0, mcVersion.lastIndexOf("."))
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/tsukimiyaproject/Lib4B")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
