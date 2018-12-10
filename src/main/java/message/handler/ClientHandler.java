package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import message.protocol.*;
import message.util.LoginUtil;

import java.util.Date;
import java.util.UUID;

/**
 * 客户端配置
 *
 * @author dengdingwwen
 * @version $Id: ClientHandler.java,v 1.0 2018/12/10 11:37 dengdingwwen
 * @date 2018/12/10 11:37
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    //该方法会在客户端建立连接成功后被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": 客户端开始登录");

        //创建登录对象
        LoginRequestPacket requestPacket = new LoginRequestPacket();
        requestPacket.setUserName("ddw");
        requestPacket.setUserId(UUID.randomUUID().toString());
        requestPacket.setPassWord("123456");

        //传输的载体ByteBuf(将登录对象序列化再放入ByteBuf中)
        //获取一个 netty 对二进制数据的抽象
        ByteBuf byteBuf = PacketCode.INSTANCE.encode(ctx.alloc(), requestPacket);

        //发送
        //写数据
        ctx.channel().writeAndFlush(byteBuf);
    }

    //接收到服务端发来的数据之后被回调
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //取出ByteBuf
        ByteBuf byteBuf = (ByteBuf)msg;

        //解码
        Packet packet = PacketCode.INSTANCE.decode(byteBuf);

        if(packet instanceof LoginResponsePacket){
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket)packet;
            if (loginResponsePacket.isSuccess()) {
                //给channel绑定属性（登录的属性）
                LoginUtil.markAsLogin(ctx.channel());
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }
        }else if(packet instanceof MessageResponsePacket){
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
        }
    }
}