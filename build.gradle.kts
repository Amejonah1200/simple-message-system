plugins {
  java
  `maven-publish`
}

group = "io.github.amejonah1200"
version = "1.0-stable"

repositories {
  maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
  maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
  maven { url = uri("https://jitpack.io") }
  mavenCentral()
  mavenLocal()
}

dependencies {
  compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
  compileOnly("org.jetbrains:annotations:16.0.2")
}

publishing {
  publications.create<MavenPublication>("maven") {
    from(components["java"])
    groupId = project.group as String?
    artifactId = project.name
    version = project.version as String?
  }

  repositories {
    maven {
      val isSnapshot = version.toString().endsWith("SNAPSHOT")
      val release = "https://eldonexus.de/repository/maven-releases/"
      val snapshot = "https://eldonexus.de/repository/maven-snapshots/"

      credentials.username = System.getenv("NEXUS_USERNAME")
      credentials.password = System.getenv("NEXUS_PASSWORD")

      name = "EldoNexus"
      url = uri(if (isSnapshot) snapshot else release)
    }
  }
}

tasks {
  compileJava {
    options.encoding = "UTF-8"
  }
  javadoc {
    options.encoding = "UTF-8"
  }
}

java {
  withSourcesJar()
  withJavadocJar()
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8
