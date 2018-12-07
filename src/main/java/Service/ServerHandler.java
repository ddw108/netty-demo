package Service;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ServerHandler.java,v 1.0 2018/12/7 10:07 dengdingwwen
 * @date 2018/12/7 10:07
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    //接收到客户端发来的数据之后被回调
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println(new Date() + " 服务端接收到数据 ：" + byteBuf.toString(Charset.forName("utf-8")));
        System.out.println(new Date() + " 服务端开始发送数据");
        ByteBuf outBuf = getByteBuf(ctx);
        ctx.channel().writeAndFlush(outBuf);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        byte[] bytes = "你好，世界！".getBytes(Charset.forName("UTF-8"));
        ByteBuf byteBuf = ctx.alloc().buffer();
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}