package com.fzx.study.seventh.client;

import com.fzx.study.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class MyProtoBufClientClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int random = new Random().nextInt(3);

        MyDataInfo.MyMessage message = null;
        if (random == 0) {
            message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).
                    setPerson(MyDataInfo.Person.newBuilder().setName("李四").
                            setAddress("长春").
                            setAge(20).
                            build())
                    .build();
        } else if (random == 1) {
            message =  MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).
                    setDog(MyDataInfo.Dog.newBuilder().setName("小白白").
                            setAge(5).
                            build()).
                    build();
        } else {
            message =MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).
                    setCat(MyDataInfo.Cat.newBuilder().
                            setName("xiaohuahua").
                            setCity("辽宁").build()).
                    build();
        }


//        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAdress("哈尔滨").setAge(28).build();
        ctx.channel().writeAndFlush(message);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }
}
