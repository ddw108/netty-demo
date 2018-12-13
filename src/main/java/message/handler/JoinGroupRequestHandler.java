package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import message.protocol.packet.JoinGroupRequestPacket;
import message.protocol.packet.JoinGroupResponsePacket;
import message.util.SessionUtil;

/**
 * 加入群聊的request处理器
 *
 * @author dengdingwwen
 * @version $Id: JoinGroupRequestHandler.java,v 1.0 2018/12/13 14:26 dengdingwwen
 * @date 2018/12/13 14:26
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 添加进去
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.add(ctx.channel());
        // 2. 构造加群响应发送给客户端
        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setGroupId(groupId);
        joinGroupResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(joinGroupResponsePacket);
    }
}