package com.fzx.study.sixth_simple.client;

import com.fzx.study.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyProtoBufClientClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       DataInfo.Student student=DataInfo.Student.newBuilder().setName("张三").setAdress("大连").setAge(28).build();
       ctx.channel().writeAndFlush(student);
    }
}
