plugins {
    id("self.chera.junit5")
}

dependencies {
    // selenium
    api("org.seleniumhq.selenium:selenium-java:3.141.59")
    api("io.github.bonigarcia:webdrivermanager:5.0.0")

    // appium
    api("io.appium:java-client:7.5.1")

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xcontext-receivers"
}
