plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"

}

group = "ru.netology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("io.appium:java-client:7.6.0")
    implementation("org.junit.jupiter:junit-jupiter-api:5.7.0")

    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.7.0")


    testImplementation("org.aspectj:aspectjweaver:1.9.7")
    testImplementation ("io.qameta.allure:allure-junit5:2.20.1")
    testImplementation ("io.qameta.allure:allure-commandline:2.20.1")
    testImplementation ("io.qameta.allure:allure-assertj:2.20.1")
    testImplementation ("io.qameta.allure:allure-rest-assured:2.20.1")
    testImplementation ("io.qameta.allure:allure-java-commons:2.20.1")
}

tasks.test {
    useJUnitPlatform()
}