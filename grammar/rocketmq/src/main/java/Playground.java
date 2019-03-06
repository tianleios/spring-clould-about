import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;

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

        for (int i = 0; i < 10; i ++) {
            Message msg = new Message("TopicTest", "TagA",
                    ("hi " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();


    }
}
