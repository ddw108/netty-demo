package message.handler.response;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.CreateGroupResponsePacket;

/**
 * 创建群聊的response处理器
 *
 * @author dengdingwwen
 * @version $Id: CreateGroupResponseHandler.java,v 1.0 2018/12/13 10:28 dengdingwwen
 * @date 2018/12/13 10:28
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
        System.out.print("群创建成功，id 为[" + msg.getGroupId() + "], ");
        System.out.println("群里面有：" + msg.getUserNameList());
    }
}