package com.tl.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQCallback implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        if (ack) {
            //消息成功到达 exchange

        } else {
            //确认未到达 exchange
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        //消息成功到达队列，不会回调

        //消息没有到达队列，会回调该方法

       String s = routingKey;

    }
}
