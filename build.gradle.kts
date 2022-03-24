plugins {
    java
    `maven-publish`
    idea
}

group = "org.reliqcraft"
version = "1.2-SNAPSHOT"
description = "PorteCullisante"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

repositories {
    mavenLocal()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
}

tasks {
    withType(JavaCompile::class) {
        options.release.set(17)
        options.encoding = Charsets.UTF_8.name()
        options.isFork = true
        options.isDeprecation = true
    }
}


publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
        }
    }
}