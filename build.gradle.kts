plugins{
    id("java")
    id("application")
}

group = "polyfauna"
version = "1.0-SNAPSHOT"

repositories{
    mavenCentral()
}

dependencies{
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    
    implementation("org.commonmark:commonmark:0.22.0")
    implementation("org.commonmark:commonmark-ext-gfm-strikethrough:0.22.0")
    implementation("org.commonmark:commonmark-ext-gfm-tables:0.22.0")
    implementation("org.commonmark:commonmark-ext-heading-anchor:0.22.0")
    implementation("org.commonmark:commonmark-ext-yaml-front-matter:0.22.0")
}

tasks.test{
    useJUnitPlatform()
}

java{
    toolchain{
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "polyfauna.website.Main"
}