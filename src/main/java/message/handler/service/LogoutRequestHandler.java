package message.handler.service;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.LogoutRequestPacket;
import message.protocol.packet.LogoutResponsePacket;
import message.util.SessionUtil;

/**
 * 登出的request处理器
 *
 * @author dengdingwwen
 * @version $Id: LogoutRequestHandler.java,v 1.0 2018/12/13 10:14 dengdingwwen
 * @date 2018/12/13 10:14
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    private LogoutRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.writeAndFlush(logoutResponsePacket);
    }
}