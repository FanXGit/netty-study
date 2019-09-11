package com.fzx.study.sixth_simple.server;

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
 * @Date :2019/9/4  17:02
 **/
public class MyProtoBufServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup boosEvent=new NioEventLoopGroup();
        EventLoopGroup workEvent=new NioEventLoopGroup();

        ServerBootstrap serverBootstrap=new ServerBootstrap();
        serverBootstrap.group(boosEvent,workEvent).channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(null);


        ChannelFuture channelFuture=serverBootstrap.bind(10001).sync();
        channelFuture.channel().closeFuture().sync();

        boosEvent.shutdownGracefully();
        workEvent.shutdownGracefully();
    }
}
