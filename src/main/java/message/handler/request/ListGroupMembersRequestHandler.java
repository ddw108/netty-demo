package message.handler.request;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import message.protocol.packet.ListGroupMembersRequestPacket;
import message.protocol.packet.ListGroupMembersResponsePacket;
import message.util.Session;
import message.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 显示群成员的request处理器
 *
 * @author dengdingwwen
 * @version $Id: ListGroupMembersRequestHandler.java,v 1.0 2018/12/13 15:01 dengdingwwen
 * @date 2018/12/13 15:01
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    private ListGroupMembersRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket msg) throws Exception {
        // 1. 获取群的 ChannelGroup
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        // 2. 遍历群成员的 channel，对应的 session，构造群成员的信息
        List<Session> sessionList = new ArrayList<>();
        for(Channel channel : channelGroup){
            Session session = SessionUtil.getSession(channel);
            sessionList.add(session);
        }
        // 3. 构建获取成员列表响应写回到客户端
        ListGroupMembersResponsePacket listGroupMembersResponsePacket = new ListGroupMembersResponsePacket();
        listGroupMembersResponsePacket.setGroupId(groupId);
        listGroupMembersResponsePacket.setSessionList(sessionList);
        ctx.channel().writeAndFlush(listGroupMembersResponsePacket);
    }
}