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
                ch.writeAndFlush(channel.remoteAddress()+"发送消息"+msg);
            }else {
                ch.writeAndFlush("你发送消息"+msg);
            }
        });


        System.out.println("---------channelRead0-------------");
    }


    /**
     * 通道注册 ，在通道add后执行
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered聊天");
        System.out.println("---------channelRegistered-------------");
        super.channelRegistered(ctx);
    }

    /**
     * 通道取消注册 ，在通道add后执行
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelUnregistered聊天");
        System.out.println("---------channelUnregistered-------------");
        super.channelUnregistered(ctx);
    }

    /**
     * 通道建立链接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"上线channelActive聊天");
        System.out.println("---------上线channelActive-------------");
        super.channelActive(ctx);
    }

    /**
     * 通道取消建立连接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered聊天");
        System.out.println("---------channelInactive-------------");
        super.channelInactive(ctx);
    }
    /**
     * 通道读取完成
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered聊天");
        System.out.println("---------channelReadComplete-------------");
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered聊天");
        System.out.println("---------userEventTriggered-------------");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered聊天");
        System.out.println("---------channelWritabilityChanged-------------");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"channelRegistered聊天");
        System.out.println("---------exceptionCaught-------------");
       ctx.close();
    }

    @Override
    protected void ensureNotSharable() {

        System.out.println("---------ensureNotSharable-------------");
        super.ensureNotSharable();
    }

    /**
     * 通道可共享的
     * @return
     */
    @Override
    public boolean isSharable() {
        System.out.println("---------isSharable-------------");
        return super.isSharable();
    }

    /**
     * 通道加入
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("---------加入（handlerAdded）-------------");
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"加入（handlerAdded）聊天");
        channelGroup.add(channel);
    }

    /**
     * 通道移除
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() +"加入（handlerRenove）聊天");
        System.out.println("---------加入（handlerRenove）-------------");
        ctx.close();
    }
}
