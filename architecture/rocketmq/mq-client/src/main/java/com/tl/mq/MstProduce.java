package com.tl.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * Created by tianlei on 2019-06-30
 */
public class MstProduce {


//    http://note.youdao.com/noteshare?id=65a535502a2da308b645183bcec74c89
    private static final String NAMESRV_ADDR = "localhost:9876";
    private static final String TOPIC = "TopicTest";


    public static void main(String[] args) throws Exception {

        consume();

//        send();


    }


    public static void send() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("first");
        producer.setNamesrvAddr(NAMESRV_ADDR);
        producer.start();

        for (int i = 20000; i < 100000; i ++) {
            Message msg = new Message(TOPIC, "TagA", ("hi " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();

    }


    public static void consume() throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CID_JODIE_1");
        consumer.subscribe(TOPIC, "*");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setConsumerGroup("tianlei_group");
        consumer.setNamesrvAddr(NAMESRV_ADDR);
        consumer.setConsumeThreadMin(10);
        consumer.setConsumeThreadMax(10);
        // 默认是1
        consumer.setConsumeMessageBatchMaxSize(1);
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);

                try {
                    Thread.sleep(10000L);
                } catch (Exception e) {
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

            }
        });
        consumer.start();

        Thread.sleep(10000000000000L);
    }


    public static void orderConsume() throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("tianlei_group");
        consumer.subscribe(TOPIC, "*");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr(NAMESRV_ADDR);
        // 默认是1
        consumer.setConsumeMessageBatchMaxSize(1);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {

                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
        });
        consumer.start();
        Thread.sleep(10000000000000L);
    }
}
