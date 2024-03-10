plugins {
    id("java")
    id("org.sonarqube") version "4.4.1.3373"
}

group = "org.wladska"
version = "1.0-SNAPSHOT"

sonar {
  properties {
    property("sonar.projectKey", "CodeGenClash")
    property("sonar.projectName", "CodeGenClash")
  }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
