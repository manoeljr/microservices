package io.github.microservices.msavaliadorcredito.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mg.queues.emissao-cartoes}")
    private String emissaoCartoesFila;

    public Queue queueEmissaoCartoes() {
        return new Queue(emissaoCartoesFila, true);
    }
}
