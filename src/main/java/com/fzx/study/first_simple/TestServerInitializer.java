package com.fzx.study.first_simple;

import io.netty.channel.*;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  10:49
 **/
public class TestServerInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {

        ChannelPipeline channelPipeline=ch.pipeline();
        channelPipeline.addLast("httpServerCodec",new HttpServerCodec());
        channelPipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());
    }
}
