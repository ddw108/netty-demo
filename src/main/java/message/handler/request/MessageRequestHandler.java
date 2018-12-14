package message.handler.request;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.MessageRequestPacket;
import message.protocol.packet.MessageResponsePacket;
import message.util.Session;
import message.util.SessionUtil;


/**
 * SimpleChannelInboundHandler通过指定泛型的类型，来确定对应处理的类型
 * 如果可以处理则自己处理，否则传递给下一个
 * 体现责任链模式
 *
 * @author dengdingwwen
 * @version $Id: MessageRequestHandler.java,v 1.0 2018/12/11 11:58 dengdingwwen
 * @date 2018/12/11 11:58
 */
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    private MessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        // 处理消息

        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());

        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());

        // 3.拿到消息接收方的 channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

        // 4.将消息发送给消息接收方
        if(toUserChannel != null && SessionUtil.hasLogin(toUserChannel)){
            toUserChannel.writeAndFlush(messageResponsePacket);
        }else{
            System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
            ctx.channel().writeAndFlush(new MessageResponsePacket("服务器", "[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!"));
        }
    }
}