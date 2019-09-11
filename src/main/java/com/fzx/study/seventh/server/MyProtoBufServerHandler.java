package com.fzx.study.seventh.server;

import com.fzx.study.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyProtoBufServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

        MyDataInfo.MyMessage.DataType.valueOf("DogType");
        if (msg.getDataType() == MyDataInfo.MyMessage.DataType.PersonType) {
            System.out.println(msg.getPerson().getName()+" :" +msg.getPerson().getAddress() +" :"+msg.getPerson().getAge());
        }else if (msg.getDataType() == MyDataInfo.MyMessage.DataType.DogType){
            System.out.println(msg.getDog().getName() +" :" +msg.getDog().getAge());
        }else{
            System.out.println(msg.getCat().getName() +" : "+msg.getCat().getCity());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        ctx.channel().close();

    }
}
