package ru.openbank.digital.serviceint.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.openbank.digital.serviceint.dto.RegistrationRequest;
import ru.openbank.digital.serviceint.dto.RegistrationResponse;

import static java.lang.Math.abs;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationService {
    @Qualifier("registrationRabbitChannel")
    private final MessageChannel registrationChannel;

    public RegistrationResponse acceptRegistrationApplication(RegistrationRequest request) {
        log.info("Receive registration request from client: {}", request);
        boolean send;
        try {
            send = registrationChannel.send(MessageBuilder.withPayload(request).build());
        } catch (Exception e) {
            log.error("Error sending registration in registration channel", e);
            send = false;
        }
        return RegistrationResponse.builder().success(send).build();
    }
}
