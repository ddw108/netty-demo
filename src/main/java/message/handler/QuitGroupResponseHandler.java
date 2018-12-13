package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.packet.QuitGroupResponsePacket;

/**
 * 退出群聊的response处理器
 *
 * @author dengdingwwen
 * @version $Id: QuitGroupResponseHandler.java,v 1.0 2018/12/13 14:51 dengdingwwen
 * @date 2018/12/13 14:51
 */
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            System.out.println("退出群聊[" + msg.getGroupId() + "]成功！");
        } else {
            System.out.println("退出群聊[" + msg.getGroupId() + "]失败！");
        }
    }
}