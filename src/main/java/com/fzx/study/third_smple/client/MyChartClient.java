package com.fzx.study.third_smple.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  15:46
 **/
public class MyChartClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();

        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new MyChartClientInitoalizer());
            ChannelFuture channelFuture=bootstrap.connect("127.0.0.1",8887).sync();


            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}
