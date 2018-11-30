package com.tl.org;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ProduceApi {

    private static String address = "localhost:9092";
    private static String topic = "streams-plaintext-input-tian";


    public static void main(String[] args) {


        consumer();

//        Properties props = new Properties();
//        props.put("bootstrap.servers", address);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        // 集群中的所有实例保存日志成功，才进行应答
//        props.put("acks", "all");
////        "org.apache.kafka.common.serialization.StringSerializer"
//
//        Producer<String, String> producer = new KafkaProducer<>(props);
//        for (int i = 0; i < 2; i++) {
//            ProducerRecord record = new ProducerRecord<String, String>(
//                    topic, Integer.toString(i), "tian lei le le");
//            producer.send(record, new Callback() {
//                @Override
//                public void onCompletion(RecordMetadata metadata, Exception exception) {
//
//                    if (null == exception) {
//                        //success
//                         int a = 10;
//                    } else {
//                        //failure
//                    }
//
//                }
//            });
//        }
//        producer.close();

//        consumer();


//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        try {
//            countDownLatch.await();
//        } catch (Exception e) {
//
//        }


        System.out.println("end ----");

    }


    public static void consumer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", address);
        //指定属于哪个消费组
        props.put("group.id", "no1");
        //每次最大拉取数量
        props.put("max.poll.records", 1);

        {// 自动提交
            if (false) {
                // 自动提交偏移
                props.put("enable.auto.commit", "true");
                // 自动提交时间
                props.put("auto.commit.interval.ms", "1000");
            } else {
                //手动提交偏移
                props.put("enable.auto.commit", "false");
            }
        }

        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);

        //必须订阅 一个 topic
        kafkaConsumer.subscribe(Arrays.asList(topic));

        //
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);

        }




    }

}
