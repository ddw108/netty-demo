package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import message.protocol.packet.QuitGroupRequestPacket;
import message.protocol.packet.QuitGroupResponsePacket;
import message.util.SessionUtil;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: QuitGroupRequestHandler.java,v 1.0 2018/12/13 14:48 dengdingwwen
 * @date 2018/12/13 14:48
 */
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket msg) throws Exception {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 移除
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());
        // 2. 构造退群响应发送给客户端
        QuitGroupResponsePacket quitGroupResponsePacket = new QuitGroupResponsePacket();
        quitGroupResponsePacket.setGroupId(groupId);
        quitGroupResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(quitGroupResponsePacket);
    }
}