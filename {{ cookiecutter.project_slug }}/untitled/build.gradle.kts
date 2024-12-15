plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }

    // We need the jogamp maven directoy has it has the latest JARs
    // This is a dependency of processing
    maven { url = uri("https://jogamp.org/deployment/maven") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Processing
    implementation("com.github.micycle1:processing-core-4:4.3.3")

    // Guava
    implementation("com.google.guava:guava:33.3.1-jre")

    // Arg parsing
    implementation("commons-cli:commons-cli:1.9.0")
}

tasks.test {
    useJUnitPlatform()
}