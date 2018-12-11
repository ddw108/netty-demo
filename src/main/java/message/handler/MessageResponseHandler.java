package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.MessageResponsePacket;

import java.util.Date;

/**
 * SimpleChannelInboundHandler通过指定泛型的类型，来确定对应处理的类型
 * 如果可以处理则自己处理，否则传递给下一个
 * 体现责任链模式
 *
 * @author dengdingwwen
 * @version $Id: MessageResponseHandler.java,v 1.0 2018/12/11 11:52 dengdingwwen
 * @date 2018/12/11 11:52
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) throws Exception {
        System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
    }
}