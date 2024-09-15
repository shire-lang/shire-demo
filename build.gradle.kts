plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm")
}

group = "com.phodal.shire"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.json:json:20231013")

	implementation("org.springframework.boot:spring-boot-starter-test")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("org.flywaydb:flyway-core")

	implementation("io.swagger:swagger-annotations:1.6.11")
	compileOnly("org.projectlombok:lombok:1.18.28")
	annotationProcessor("org.projectlombok:lombok:1.18.28")
	// h2
	implementation("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
