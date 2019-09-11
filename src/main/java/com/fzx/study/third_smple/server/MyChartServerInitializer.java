package com.fzx.study.third_smple.server;

import io.netty.channel.*;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/8/28  17:40
 **/
public class MyChartServerInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {

        ChannelPipeline  channelPipeline=ch.pipeline();

        channelPipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
        channelPipeline.addLast(new LengthFieldPrepender(4));
        channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        channelPipeline.addLast(new MyChartServerHander());

    }



}
