package com.fzx.study.first_simple;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  10:53
 **/
public class TestHttpServerHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HttpRequest){
            HttpRequest httpRequest=(HttpRequest)msg;
            System.out.println("方法请求名："+httpRequest.method().name());

            URI uri=new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求favicon.ico");
                return;
            }

            ByteBuf content= Unpooled.copiedBuffer("Hello Word", CharsetUtil.UTF_8);
            FullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
            ctx.writeAndFlush(response);

        }
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------channelActive------");
        super.channelActive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------channelRegistered------");
        super.channelRegistered(ctx);
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------channelInactive------");
        super.channelInactive(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------handlerAdded------");
        super.handlerAdded(ctx);
    }
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("--------------channelUnregistered------------");
        super.channelUnregistered(ctx);
    }



}
