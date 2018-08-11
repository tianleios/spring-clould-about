package com.tl.org;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;

import java.util.Arrays;
import java.util.Properties;

public class ServerApi {

    // 服务端 api 管理
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093");
        AdminClient adminClient = KafkaAdminClient.create(properties);
        adminClient.listTopics();

        // name partitions replication
        NewTopic newTopic = new NewTopic("api-topic", 1, (short) 1);
        CreateTopicsResult result = adminClient.createTopics(Arrays.asList(newTopic));
        KafkaFuture kafkaFuture = result.all();
        try {
            kafkaFuture.get();
        } catch (Exception e) {

        }


    }
}
