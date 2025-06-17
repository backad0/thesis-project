import org.springframework.boot.gradle.tasks.bundling.BootJar

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.5"
    id("nu.studer.jooq") version "8.1"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework:spring-jdbc")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.uuid:java-uuid-generator")
    implementation("org.apache.kafka:kafka-clients")
    implementation("org.camunda.bpm:camunda-engine")
    implementation("org.flywaydb:flyway-core")
    implementation("com.zaxxer:HikariCP")

    // JOOQ dependencies
    implementation("org.jooq:jooq:3.18.0")
    jooqGenerator("org.postgresql:postgresql:42.6.0")

    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core")
    testImplementation("io.mockk:mockk")
}

tasks.bootJar {
    mainClass = "my.thesis.ApplicationStorageApplicationKt"
}
