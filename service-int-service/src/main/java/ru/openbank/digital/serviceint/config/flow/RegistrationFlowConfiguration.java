package ru.openbank.digital.serviceint.config.flow;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
@RequiredArgsConstructor
public class RegistrationFlowConfiguration {

    @Bean("registrationChannel")
    public MessageChannel registrationChannel() {
        return new DirectChannel();
    }

    @Bean("registrationRabbitChannel")
    public MessageChannel registrationRabbitChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow amqpFromQueueFlow(ConnectionFactory rabbitConnectionFactory, MessageConverter converter) {
        return IntegrationFlows.from(Amqp.inboundAdapter(rabbitConnectionFactory, "registration_queue")
                        .messageConverter(converter))
                .log(message ->  "Handle message directly from registration_queue : Received Message : " + message.getPayload())
                .channel(registrationChannel())
                .get();
    }

    @Bean
    public IntegrationFlow channelToRabbit(AmqpTemplate amqpTemplate) {
        return IntegrationFlows.from(registrationRabbitChannel())
                .log(message -> "Handle message from registrationRabbitChannel : Received Message : " + message.getPayload())
                .handle(Amqp.outboundAdapter(amqpTemplate).routingKey("registration_queue"))
                .get();
    }


}
