package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.MessageRequestPacket;
import message.protocol.MessageResponsePacket;

import java.util.Date;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: MessageResquestHandler.java,v 1.0 2018/12/11 11:58 dengdingwwen
 * @date 2018/12/11 11:58
 */
public class MessageResquestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        // 处理消息
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}