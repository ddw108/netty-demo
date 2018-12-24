package message.handler.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.HeartBeatRequestPacket;
import message.protocol.packet.HeartBeatResponsePacket;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: HeartBeatRequestHandler.java,v 1.0 2018/12/24 15:36 dengdingwwen
 * @date 2018/12/24 15:36
 */
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();

    private HeartBeatRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket msg) throws Exception {
        ctx.writeAndFlush(new HeartBeatResponsePacket());
    }
}