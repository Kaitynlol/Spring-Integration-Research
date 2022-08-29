package ru.openbank.digital.serviceint.config.flow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
@Slf4j
public class CdiRegistrationFlowConfiguration {

    @Bean("cdiChannel")
    public MessageChannel cdiChannel() {
        return new DirectChannel();
    }


    @Bean
    public IntegrationFlow amqpFromCdiChannelFlow() {
        return IntegrationFlows.from(cdiChannel())
                .log(message -> "Handle message from cdiChannel : Received Message : " + message.getPayload())
                .handle(m -> log.info("Just do some logging: {}", m))
                .get();
    }
}
