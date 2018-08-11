package com.tl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(KafkaApplication.class);

    }


    @Autowired
    private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {

        {
            //server.properties 配置文件中可以设置默认的分区数量
            //KafkaAdmin 可以创建topic, 并指定分区数量
        }

        this.template.send("myTopic", "foo1");
        this.template.send("myTopic", "foo2");
        this.template.send("myTopic", "foo3");
        this.template.send("sheTopic", "she3");
        latch.await(60, TimeUnit.SECONDS);
    }

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        int a = 10;
    }

    @KafkaListener(topics = "sheTopic",topicPartitions = {
            @TopicPartition(topic = "sheTopic", partitions = "0"),
            @TopicPartition(topic = "sheTopic", partitions = "1")
    })
    public void listenShe(ConsumerRecord<?, ?> cr) throws Exception {
        int a = 10;
    }


}
