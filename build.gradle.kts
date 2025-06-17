plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.5"
}

subprojects {
    apply(plugin = "io.spring.dependency-management")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.18")
            mavenBom("org.camunda.bpm:camunda-bom:7.14.0")
        }

        dependencies {
            dependency("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
            dependency("com.fasterxml.jackson.core:jackson-databind:2.16.0")
            dependency("com.fasterxml.uuid:java-uuid-generator:4.3.0")
            dependency("org.apache.kafka:kafka-clients:3.6.0")
            dependency("org.postgresql:postgresql:42.6.0")
            dependency("com.h2database:h2:2.2.224")
            dependency("org.camunda.bpm:camunda-engine:7.14.0")

            // Тестовые зависимости
            dependency("org.junit.jupiter:junit-jupiter:5.9.3")
            dependency("org.assertj:assertj-core:3.24.2")
            dependency("io.mockk:mockk:1.13.8")
        }
    }

    repositories {
        mavenCentral()
    }
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}


allprojects {
    group = "my.thesis"
}
