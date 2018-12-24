package message.handler.service;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import message.protocol.Packet;
import message.protocol.PacketCode;

import java.util.List;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: PacketCodecHandler.java,v 1.0 2018/12/24 10:06 dengdingwwen
 * @date 2018/12/24 10:06
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    private PacketCodecHandler() {

    }

    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, List<Object> out) throws Exception {
        ByteBuf byteBuf = ctx.alloc().ioBuffer();
        PacketCode.INSTANCE.encode(byteBuf, packet);
        out.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        out.add(PacketCode.INSTANCE.decode(byteBuf));
    }
}