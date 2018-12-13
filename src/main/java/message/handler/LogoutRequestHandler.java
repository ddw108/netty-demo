package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.LogoutRequestPacket;
import message.protocol.packet.LogoutResponsePacket;
import message.util.SessionUtil;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LogoutRequestHandler.java,v 1.0 2018/12/13 10:14 dengdingwwen
 * @date 2018/12/13 10:14
 */
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(logoutResponsePacket);
    }
}