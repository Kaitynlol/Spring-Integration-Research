package ru.openbank.digital.serviceint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;

@Configuration
@ComponentScan({
        "ru.openbank.digital.serviceint.service",
        "ru.openbank.digital.serviceint.config",
        "ru.openbank.digital.serviceint.controller"})
@EnableIntegration
public class ServiceIntBackConfiguration {
}
