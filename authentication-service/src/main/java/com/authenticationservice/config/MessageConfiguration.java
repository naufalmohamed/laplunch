package com.authenticationservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

    public static final String QUEUE = "user_credentials";
    public static final String EXCHANGE = "credentials_exchange";
    public static final String ROUTING_KEY = "message_routingKey";
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }
    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }
    @Bean
    Binding bindingUser(Queue QUEUE, TopicExchange EXCHANGE) {
        return BindingBuilder.bind(QUEUE).to(EXCHANGE).with(ROUTING_KEY);
    }
}
