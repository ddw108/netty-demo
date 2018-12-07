package Client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ClientHandler.java,v 1.0 2018/12/7 10:01 dengdingwwen
 * @date 2018/12/7 10:01
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    //该方法会在客户端建立连接成功后被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(new Date() + " 客户端开始发送数据");
        //获取一个 netty 对二进制数据的抽象
        ByteBuf byteBuf = getByteBuf(ctx);
        //写数据
        ctx.channel().writeAndFlush(byteBuf);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {

        //准备数据，指定字符集为UTF-8
        byte[] bytes = "Hello world !".getBytes(Charset.forName("utf-8"));
        //获取二进制抽象ByteBuf（Netty中的数据都是ByteBuf）
        ByteBuf buffer = ctx.alloc().buffer();
        //填充数据到ByteBuf
        buffer.writeBytes(bytes);
        return buffer;
    }

    //接收到服务端发来的数据之后被回调
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println(new Date() + " 客户端接收到数据 ：" + byteBuf.toString(Charset.forName("utf-8")));
    }
}