package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.JoinGroupResponsePacket;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: JoinGroupResponseHandler.java,v 1.0 2018/12/13 14:31 dengdingwwen
 * @date 2018/12/13 14:31
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            System.out.println("加入群[" + msg.getGroupId() + "]成功!");
        } else {
            System.err.println("加入群[" + msg.getGroupId() + "]失败，原因为：" + msg.getReason());
        }
    }
}