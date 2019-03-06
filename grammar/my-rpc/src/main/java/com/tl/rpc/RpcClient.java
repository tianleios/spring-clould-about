package com.tl.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by tianlei on 2019/2/27
 */
public class RpcClient {

    private static volatile RpcClient client = null;
    private Channel channel = null;

    public static RpcClient getInstance() {

        if (client == null) {
            synchronized (RpcClient.class) {
                if (client == null) {
                    client = new RpcClient();
                    client.init();
                }
            }
        }

        return client;
    }


    public Channel getChannel() {
        return channel;
    }

    private RpcClient() {
    }

    private void init() {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });
        channel = bootstrap.connect("127.0.0.1", 8000).channel();
    }
}
