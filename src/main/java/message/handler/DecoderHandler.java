package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import message.protocol.PacketCode;

import java.util.List;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: DecoderHandler.java,v 1.0 2018/12/11 11:40 dengdingwwen
 * @date 2018/12/11 11:40
 */
public class DecoderHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketCode.INSTANCE.decode(in));
    }
}