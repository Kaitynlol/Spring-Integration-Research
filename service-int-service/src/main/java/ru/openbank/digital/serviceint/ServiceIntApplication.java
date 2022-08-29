package ru.openbank.digital.serviceint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.openbank.digital.serviceint.config.ServiceIntBackConfiguration;

@SpringBootApplication
@Import(ServiceIntBackConfiguration.class)
public class ServiceIntApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceIntApplication.class, args);
    }
}
