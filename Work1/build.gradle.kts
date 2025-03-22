plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("war")
}

group = "org.piva"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "org.piva.Main"
}

dependencies {
    implementation("org.springframework:spring-webmvc:6.2.5")
    implementation("org.springframework.data:spring-data-jpa:3.4.4")
    implementation("org.hibernate.orm:hibernate-core:6.6.11.Final")
    implementation("org.postgresql:postgresql:42.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:11.0.5")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}