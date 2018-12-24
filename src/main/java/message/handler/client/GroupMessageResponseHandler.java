package message.handler.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.GroupMessageResponsePacket;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: GroupMessageResponseHandler.java,v 1.0 2018/12/14 15:38 dengdingwwen
 * @date 2018/12/14 15:38
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        String fromUserId = msg.getFromUser().getUserId();
        String fromGroupId = msg.getFromGroupId();
        String fromUserName = msg.getFromUser().getUserName();
        System.out.println("【收到" + fromGroupId + "群消息】" + fromUserId + ":" + fromUserName + " -> " + msg
                .getMessage());
    }
}