package com.fzx.study.third_smple.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  17:17
 **/
public class MyChartServer {

    public static void main(String[] args) {
        //接收
        EventLoopGroup bossEvent=new NioEventLoopGroup();
        //处理返回
        EventLoopGroup workEvent=new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(bossEvent,workEvent).channel(NioServerSocketChannel.class)
                    .childHandler(new MyChartServerInitializer());
            ChannelFuture channelFuture=serverBootstrap.bind(8887).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossEvent.shutdownGracefully();
            workEvent.shutdownGracefully();
        }


    }
}
