import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.compile.JavaCompile


plugins {
	kotlin("jvm") version "1.4.30-M1"
	id("io.freefair.lombok") version "5.3.0"
	idea
	application
	java
}
apply {
	plugin("kotlin")
}

repositories {
	mavenLocal()
	mavenCentral()
	jcenter()
}

application {
	mainClass.set("de.chrisliebaer.helloworld.HelloWorld")
}

java {
	sourceCompatibility = JavaVersion.VERSION_15
	targetCompatibility = JavaVersion.VERSION_15
}

idea {
	module {
		isDownloadJavadoc = true
		isDownloadSources = true
	}
}

tasks.withType(KotlinCompile::class.java).all {
	kotlinOptions {
		jvmTarget = "15"
	}
}

tasks.withType(JavaCompile::class.java).all {
	options.encoding = "UTF-8"
}
