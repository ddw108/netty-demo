package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.LogoutResponsePacket;
import message.util.SessionUtil;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LogoutResponseHandler.java,v 1.0 2018/12/13 10:17 dengdingwwen
 * @date 2018/12/13 10:17
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}