package com.tl.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.channels.WritableByteChannel;

/**
 * Created by tianlei on 2018/12/5
 */
public class NIOTest {

    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("");
        ReadableByteChannel readChannel = fis.getChannel();

        //
        FileOutputStream fos = new FileOutputStream("");
        WritableByteChannel writeChannel = fos.getChannel();


        Selector selector = Selector.open();

    }


    @Test
    public void selector() throws Exception {




    }


    // file channel 不是非阻塞的，不能使用selector
    @Test
    public void readFile() throws Exception {

        FileInputStream fis = new FileInputStream("src/main/resources/text.txt");
        FileChannel fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // channel -> 缓冲区
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        StringBuffer buffer = new StringBuffer();
        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            buffer.append((char) b);
        }
        System.out.println(buffer.toString());

        fis.close();
        fileChannel.close();
    }

    @Test
    public void writeFile() throws Exception {

        FileOutputStream fos = new FileOutputStream("src/main/resources/out.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("i am out".getBytes());
        buffer.flip();
        FileChannel fileChannel = fos.getChannel();
        fileChannel.write(buffer);

        fos.close();
        fileChannel.close();

    }

}
