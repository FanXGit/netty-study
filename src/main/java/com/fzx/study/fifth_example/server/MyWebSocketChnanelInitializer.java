package com.fzx.study.fifth_example.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/9/2  15:32
 **/
public class MyWebSocketChnanelInitializer  extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline=ch.pipeline();

        channelPipeline.addLast(new HttpServerCodec());
        channelPipeline.addLast(new ChunkedWriteHandler());
        channelPipeline.addLast(new HttpObjectAggregator(8936));
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/fzx"));
        channelPipeline.addLast(new MyTextWebSocketFrameHandler());
    }
}
