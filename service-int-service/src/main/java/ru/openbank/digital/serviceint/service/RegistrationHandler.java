package ru.openbank.digital.serviceint.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import ru.openbank.digital.serviceint.api.PrepareClient;
import ru.openbank.digital.serviceint.dto.RegistrationRequest;
import ru.openbank.digital.serviceint.model.ClientInfo;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
@RequiredArgsConstructor
@MessageEndpoint
public class RegistrationHandler implements PrepareClient {
    private final CdiRegistrationService cdiRegistrationService;
    private AtomicInteger ids = new AtomicInteger();

    @Override
    @ServiceActivator(inputChannel="registrationChannel")
    public void prepareClientInfo(RegistrationRequest request) {
        log.info("Handle registration request from queue: {}", request);
        cdiRegistrationService.register(ClientInfo.builder()
                .id(ids.incrementAndGet())
                .name(request.getName())
                .birthDay(request.getBirthDay())
                .build());
    }
}
