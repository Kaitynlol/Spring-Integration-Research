buildscript {
    val repositoryUrl: String by project
    val javaLibsRepo: String by project
    val dependencyManagementVersion: String by project

    repositories {
        mavenLocal()
        maven { url = uri(javaLibsRepo) }
        maven { url = uri(repositoryUrl) }
    }

    dependencies {
        classpath(platform("ru.openbank.digital:dependencies:$dependencyManagementVersion"))
        classpath("org.springframework.boot:spring-boot-gradle-plugin")
    }
}

allprojects {
    val repositoryUrl: String by project
    val javaLibsRepo: String by project

    repositories {
        mavenLocal()
        maven { url = uri(javaLibsRepo) }
        maven { url = uri(repositoryUrl) }
        mavenCentral()
    }
}

subprojects {
    val dependencyManagementVersion: String by project

    apply(plugin = "java")

    dependencies {
        "implementation"(platform("ru.openbank.digital:dependencies:$dependencyManagementVersion"))
        "annotationProcessor"(platform("ru.openbank.digital:dependencies:$dependencyManagementVersion"))
        "testCompileOnly"(platform("ru.openbank.digital:dependencies:$dependencyManagementVersion"))
        "testAnnotationProcessor"(platform("ru.openbank.digital:dependencies:$dependencyManagementVersion"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
