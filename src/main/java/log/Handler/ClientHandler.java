package log.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import log.protocol.LoginRequestPacket;
import log.protocol.LoginResponsePacket;
import log.protocol.Packet;
import log.protocol.PacketCode;

import java.util.Date;
import java.util.UUID;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ClientHandler.java,v 1.0 2018/12/10 11:37 dengdingwwen
 * @date 2018/12/10 11:37
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": 客户端开始登录");

        //创建登录对象
        LoginRequestPacket requestPacket = new LoginRequestPacket();
        requestPacket.setUserName("ddw");
        requestPacket.setUserId(UUID.randomUUID().toString());
        requestPacket.setPassWord("123456");

        //传输的载体ByteBuf(将登录对象序列化再放入ByteBuf中)
        ByteBuf byteBuf = PacketCode.INSTANCE.encode(ctx.alloc(), requestPacket);

        //发送
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //取出ByteBuf
        ByteBuf byteBuf = (ByteBuf)msg;

        //解码
        Packet packet = PacketCode.INSTANCE.decode(byteBuf);

        if(packet instanceof LoginResponsePacket){
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket)packet;
            if (loginResponsePacket.isSuccess()) {
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }
        }
    }
}