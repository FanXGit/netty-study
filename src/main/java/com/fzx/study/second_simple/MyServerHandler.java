package com.fzx.study.second_simple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  15:43
 **/
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        ctx.channel().writeAndFlush("fromServer: "+ UUID.randomUUID());

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.getStackTrace();
        ctx.close();
    }
}
