package com.tl.service.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    /*
      启动类上有 @EnableRabbit 启动Rabbit
      配置信息在RabbitMQConfig 中
    * */

    @Autowired
    RabbitTemplate rabbitTemplate;


    public void sendMsg() {

        //1.发送者 发送消息怎样确认消息已经被持久化到队列
        //2.消费者 怎样告诉 broker 已经处理完了该消息
        //3.消费者主动获取消息


        String msg = "hellow word";

        //该消息会发送失败，如果不存在该交换机
//        this.rabbitTemplate.convertAndSend("topicExchange","topic",msg);


        for (int i = 0 ; i < 100; i ++) {

            String totalMsg = msg + new  Integer(i).toString();
            //在下面监听器中可以收到消息监听
            this.rabbitTemplate.convertAndSend("","myQueue",totalMsg,new CorrelationData(totalMsg));

//            this.rabbitTemplate.convertAndSend("myTopicExchange","topic." + new Integer(i).toString(),totalMsg,new CorrelationData(totalMsg + "topic"));
        }


    }

    @RabbitListener(id="first",queues = {"myQueue"},containerFactory = "rabbitListenerContainerFactory")
    public void listener01(Message message, Channel channel) {

        message.toString();
        try {
           //要在配置文件中配置手动确认
           //不确认就会消息重回消息队列
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);


//            channel.basicNack();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
//
//    @RabbitListener(id="second",queues = {"myQueue"})
//    public void listener02(Message message) {
//
//        message.toString();
//
//    }
//
    @RabbitListener(id="third",queues = {"myCustomQueue"})
    public void listenerCustomQueue(Message message) {

            message.toString();

    }

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");


        try {

            //创建一个连接
            Connection connection = factory.newConnection();

            //创建一个chaale
            Channel channel = connection.createChannel();

            String queueName = "secondQueue";
            String msg = "hello world 2";
            channel.queueDeclare(queueName,
                    true,
                    false,
                    false,
                    null);

            //生产
            {

                channel.basicPublish("", queueName, null, msg.getBytes("UTF-8"));

                //
//                channel.close();
//                connection.close();
            }

            //消费
            {
//                Consumer consumer = new DefaultConsumer(channel) {
//                    @Override
//                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//
//                        String message = new String(body, "UTF-8");
//
//                    }
//                };
//
//                channel.basicConsume(queueName,true,consumer);
            }


        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}
