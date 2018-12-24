package message.handler.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.ListGroupMembersResponsePacket;

/**
 * 显示群成员的response处理器
 *
 * @author dengdingwwen
 * @version $Id: ListGroupMembersResponseHandler.java,v 1.0 2018/12/13 15:09 dengdingwwen
 * @date 2018/12/13 15:09
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket msg) throws Exception {
        System.out.println("群[" + msg.getGroupId() + "]中的人包括：" + msg.getSessionList());
    }
}