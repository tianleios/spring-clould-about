import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by tianlei on 2019/3/4
 */
public class Playground {

    private static String NAMESRV_ADDR = "localhost:9876";

    @Test
    public void simpleSend() throws Exception {


        DefaultMQProducer producer = new DefaultMQProducer("first");
        producer.setNamesrvAddr(NAMESRV_ADDR);
        producer.start();

        for (int i = 20000; i < 30000; i ++) {
            Message msg = new Message("TopicTest", "TagA", "order" + i,
                    ("hi " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();


    }


    @Test
    public void consumerPush() throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CID_JODIE_1");
        consumer.subscribe("TopicTest", "*");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setInstanceName("consumer1");
        consumer.setNamesrvAddr(NAMESRV_ADDR);
        consumer.setConsumeThreadMin();
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

            }
        });
        consumer.start();
        Thread.sleep(100);
    }

    //@Test
    //public void consumerPull() throws Exception {
    //    DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("please_rename_unique_group_name_5");
    //    consumer.setNamesrvAddr("127.0.0.1:9876");
    //    consumer.setInstanceName("consumer");
    //    consumer.start();
    //
    //    Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("TopicTest111");
    //    for (MessageQueue mq : mqs) {
    //        System.out.printf("Consume from the queue: %s%n", mq);
    //        SINGLE_MQ:
    //        while (true) {
    //            try {
    //                PullResult pullResult =
    //                    consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
    //                System.out.printf("%s%n", pullResult);
    //                putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
    //                switch (pullResult.getPullStatus()) {
    //                    case FOUND:
    //                        System.out.println(pullResult.getMsgFoundList().get(0).toString());
    //                        break;
    //                    case NO_NEW_MSG:
    //                        break SINGLE_MQ;
    //                    case NO_MATCHED_MSG:
    //                    case OFFSET_ILLEGAL:
    //                        break;
    //                    default:
    //                        break;
    //                }
    //            } catch (Exception e) {
    //                //TODO
    //            }
    //        }
    //    }
    //    consumer.shutdown();
    //}
}
