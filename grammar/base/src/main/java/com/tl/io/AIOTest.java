package com.tl.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tianlei on 2018/12/5
 */
public class AIOTest {

    public static void main(String[] args) throws Exception {

//       Path path = Paths.get("src/main/resources/text.txt");
        Path path = Paths.get("/Users/leitian/Documents/spring-clould-about/grammar/base/src/main/resources/text.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("完成了" + new String(attachment.array()));
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("读取失败");
            }
        });

        Thread.sleep(1000);
        System.out.println("sleep");

    }

}
