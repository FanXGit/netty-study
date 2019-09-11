package com.fzx.study.sixth_simple.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/9/4  17:03
 **/
public class MyProtoBufClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                .handler(null);
            ChannelFuture channelFuture=bootstrap.connect("127.0.0.1",8887).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();

            eventLoopGroup.shutdownGracefully();
        }
    }
}




