plugins {
    java
    `maven-publish`
    idea
}

group = "org.reliqcraft"
version = "1.2-SNAPSHOT"
description = "PorteCoullisante"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
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
            pom {
                scm {
                    connection.set("scm:git:git://github.com/md5sha256/PorteCoulissante.git")
                    developerConnection.set("scm:git:ssh://github.com/md5sha256/PorteCoulissante.git")
                    url.set("https://github.com/md5sha256/PorteCoulissante")
                }
                licenses {
                    license {
                        name.set("GNU General Public License v3.0")
                        url.set("https://github.com/md5sha256/PorteCoulissante/blob/master/LICENSE")
                    }
                }
            }
        }
    }
}