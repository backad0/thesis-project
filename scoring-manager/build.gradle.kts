import org.springframework.boot.gradle.tasks.bundling.BootJar

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.5"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.uuid:java-uuid-generator")
    implementation("org.apache.kafka:kafka-clients")
    implementation("org.postgresql:postgresql")
    implementation("org.camunda.bpm:camunda-engine")

    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core")
    testImplementation("io.mockk:mockk")
}

tasks.bootJar {
    mainClass = "my.thesis.ScoringManagerApplicationKt"
}
