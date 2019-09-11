package com.fzx.study.fifth_example.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/9/2  15:24
 **/
public class MyFifthServer {
    public static void main(String[] args) {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();


        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, workGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new MyWebSocketChnanelInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(10000).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }
}
