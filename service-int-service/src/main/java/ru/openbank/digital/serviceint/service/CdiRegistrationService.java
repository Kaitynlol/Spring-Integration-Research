package ru.openbank.digital.serviceint.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import ru.openbank.digital.serviceint.api.RegisterClientInCdi;
import ru.openbank.digital.serviceint.model.ClientInfo;

@Slf4j
@Component
@RequiredArgsConstructor
public class CdiRegistrationService implements RegisterClientInCdi {

    @Qualifier("cdiChannel")
    private final MessageChannel cdiChannel;

    @Override
    public void register(ClientInfo clientInfo) {
        log.info("Try to create client in cdi: {}", clientInfo);
        try {
            cdiChannel.send(MessageBuilder.withPayload(clientInfo).build());
        } catch (Exception e) {
            log.error("Error sending registration in cdi channel", e);
        }
    }
}
