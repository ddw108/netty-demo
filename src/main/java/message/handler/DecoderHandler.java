package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import message.protocol.PacketCode;

import java.util.List;

/**
 * 定义解码方式
 *
 * @author dengdingwwen
 * @version $Id: DecoderHandler.java,v 1.0 2018/12/11 11:40 dengdingwwen
 * @date 2018/12/11 11:40
 */
public class DecoderHandler extends ByteToMessageDecoder {

    /**
     * ByteToMessageDecoder父类专门处理解码
     * 通过往这个 List 里面添加解码后的结果对象，
     * 就可以自动实现结果往下一个 handler 进行传递
     *
     * 另外，不需要自己定义ByteBuf，自动创建和释放，
     * 否则其属于堆外内存，需要单独释放
     * */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketCode.INSTANCE.decode(in));
    }
}