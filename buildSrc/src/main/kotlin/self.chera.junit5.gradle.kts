
plugins {
    id("self.chera.kotlin")
}

dependencies {
    // junit 5
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.kotest:kotest-assertions-core:5.3.0")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
