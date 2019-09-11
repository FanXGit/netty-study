package com.fzx.study.sixth_simple.server;

import com.fzx.study.protobuf.DataInfo;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyProtoBufServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        Channel channel=ctx.channel();
        System.out.println( channel.remoteAddress()+" 传来消息:"+ msg.getName() +" :" +msg.getAge()  +" :" +msg.getAdress());
    }
}
