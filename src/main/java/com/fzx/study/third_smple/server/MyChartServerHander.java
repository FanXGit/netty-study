package com.fzx.study.third_smple.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  18:02
 **/
public class MyChartServerHander extends SimpleChannelInboundHandler {
    private static ChannelGroup  channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.forEach(ch -> {
            if (ch !=channel){
                ch.writeAndFlush(channel.remoteAddress()+"������Ϣ"+msg);
            }else {
                ch.writeAndFlush("�㷢����Ϣ"+msg);
            }
        });


        System.out.println("---------channelRead0-------------");
    }


    /**
     * ͨ��ע�� ����ͨ��add��ִ��
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered����");
        System.out.println("---------channelRegistered-------------");
        super.channelRegistered(ctx);
    }

    /**
     * ͨ��ȡ��ע�� ����ͨ��add��ִ��
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelUnregistered����");
        System.out.println("---------channelUnregistered-------------");
        super.channelUnregistered(ctx);
    }

    /**
     * ͨ����������
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"����channelActive����");
        System.out.println("---------����channelActive-------------");
        super.channelActive(ctx);
    }

    /**
     * ͨ��ȡ����������
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered����");
        System.out.println("---------channelInactive-------------");
        super.channelInactive(ctx);
    }
    /**
     * ͨ����ȡ���
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered����");
        System.out.println("---------channelReadComplete-------------");
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered����");
        System.out.println("---------userEventTriggered-------------");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered����");
        System.out.println("---------channelWritabilityChanged-------------");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered����");
        System.out.println("---------exceptionCaught-------------");
       ctx.close();
    }

    @Override
    protected void ensureNotSharable() {

        System.out.println("---------ensureNotSharable-------------");
        super.ensureNotSharable();
    }

    /**
     * ͨ���ɹ����
     * @return
     */
    @Override
    public boolean isSharable() {
        System.out.println("---------isSharable-------------");
        return super.isSharable();
    }

    /**
     * ͨ������
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("---------���루handlerAdded��-------------");
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"���루handlerAdded������");
        channelGroup.add(channel);
    }

    /**
     * ͨ���Ƴ�
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"���루handlerRenove������");
        System.out.println("---------���루handlerRenove��-------------");
        ctx.close();
    }
}
