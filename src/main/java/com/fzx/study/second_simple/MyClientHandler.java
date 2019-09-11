package com.fzx.study.second_simple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  15:55
 **/
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output:"+msg);
        ctx.channel().writeAndFlush("from client: "+ LocalDateTime.now());

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("hello");
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.getStackTrace();
        ctx.close();
    }
}
