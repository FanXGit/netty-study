package com.fzx.study.second_simple;


import io.netty.bootstrap.ServerBootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  15:28
 **/
public class MyServer {
    public static void main(String[] args) {
        EventLoopGroup  bossLoop=new NioEventLoopGroup();
        EventLoopGroup  workLoop=new NioEventLoopGroup();


        try {
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(bossLoop,workLoop).channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitializer());
            ChannelFuture channelFuture=bootstrap.bind(8889).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            bossLoop.shutdownGracefully();
            workLoop.shutdownGracefully();
        }

    }
}
