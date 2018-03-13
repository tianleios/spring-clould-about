package com.tl.config;

import com.tl.service.impl.RabbitMQCallback;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMQConfig {

    @Autowired
    RabbitMQCallback rabbitMQCallback;

    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");

        //为了启用 发送消息 成功的回调， RabbitTemplate 也要进行相应设置
        cachingConnectionFactory.setPublisherConfirms(true);
        cachingConnectionFactory.setPublisherReturns(true);
        return  cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {

        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.declareQueue(myQueue());

        //
        rabbitAdmin.declareQueue(myCustomQueue());

        TopicExchange topicExchange = new TopicExchange("myTopicExchange");
        rabbitAdmin.declareExchange(topicExchange);

        rabbitAdmin.declareBinding(BindingBuilder.bind(myCustomQueue()).to(topicExchange).with("topic.*"));
        return rabbitAdmin;

    }

    @Bean
    public RabbitTemplate rabbitTemplate() {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory());

//        //为了启用 发送消息 成功的回调， CachingConnectionFactory 也要进行相应设置
        rabbitTemplate.setMandatory(true);
//
//        //确认回调
        rabbitTemplate.setConfirmCallback(rabbitMQCallback);
        //消息发送失败回调
        rabbitTemplate.setReturnCallback(rabbitMQCallback);

        return rabbitTemplate;

    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(CachingConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        //设置拉取数量为1
        factory.setPrefetchCount(1);
        return factory;
    }


    @Bean
    public Queue myQueue() {

        return new Queue("myQueue",true,false,false);

    }

    @Bean
    public Queue myCustomQueue() {

        return new Queue("myCustomQueue",true,false,false);

    }



}
