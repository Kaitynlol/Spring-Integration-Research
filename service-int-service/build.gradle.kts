plugins {
    id("org.springframework.boot")
}

val rabbitmqStarterVersion: String by project
val tibcoStarterVersion: String by project

dependencies {

    /**
     * Базовые библиотеки
     */
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-webmvc")


    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-json")

    implementation("org.springframework.boot:spring-boot-loader")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")
    /**
     * Внещние зависимости
     */
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.mapstruct:mapstruct")
    annotationProcessor("org.mapstruct:mapstruct-processor")

    implementation("org.freemarker:freemarker")
    implementation("javax.mail:mail")

    implementation("org.springframework.integration:spring-integration-jms")
    implementation("org.springframework.integration:spring-integration-amqp")


    /**
     * Тестовые зависимости
     */
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
}
