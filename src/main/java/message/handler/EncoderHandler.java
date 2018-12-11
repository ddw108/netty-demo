package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import message.protocol.Packet;
import message.protocol.PacketCode;

/**
 * 把响应对象编码成 ByteBuf
 *
 * @author dengdingwwen
 * @version $Id: EncoderHandler.java,v 1.0 2018/12/11 11:42 dengdingwwen
 * @date 2018/12/11 11:42
 */
public class EncoderHandler extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        PacketCode.INSTANCE.encode(out, packet);
    }
}