import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
	id("org.flywaydb.flyway") version "7.15.0"
}

group = "io.devpass"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// HTTP
	implementation("com.github.kittinunf.fuel:fuel:2.3.1")
	implementation("com.github.kittinunf.fuel:fuel-jackson:2.3.1")

	// Database
	implementation("mysql:mysql-connector-java")
	implementation("org.flywaydb:flyway-core:7.15.0")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.tngtech.archunit:archunit-junit4:1.0.0-rc1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

kotlin.sourceSets["test"].kotlin.srcDirs("src/test", "src/archTest")
