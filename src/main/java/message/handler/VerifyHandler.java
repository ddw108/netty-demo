package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import message.protocol.PacketCode;

/**
 * 继承自基于长度域拆包器
 *
 * @author dengdingwwen
 * @version $Id: VerifyHandler.java,v 1.0 2018/12/11 15:05 dengdingwwen
 * @date 2018/12/11 15:05
 */
public class VerifyHandler extends LengthFieldBasedFrameDecoder {

    private static final int LENGTH_FIELD_OFFSET = 7;
    private static final int LENGTH_FIELD_LENGTH = 4;

    public VerifyHandler() {
        //第二个参数代表偏移量，第三个参数代表长度域，读出的结果为包的长度大小
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 屏蔽非本协议的客户端，当协议结果不对时，应该关闭连接
        if (in.getInt(in.readerIndex()) != PacketCode.MAGIC_NUMBER) {
            ctx.channel().close();
            return null;
        }
        return super.decode(ctx, in);
    }
}