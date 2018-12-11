package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.*;
import message.util.LoginUtil;

import java.util.Date;
import java.util.UUID;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LoginResponseHandler.java,v 1.0 2018/12/11 11:47 dengdingwwen
 * @date 2018/12/11 11:47
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            //给channel绑定属性（登录的属性）
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date() + ": 客户端登录成功");
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": 客户端开始登录");

        //创建登录对象
        LoginRequestPacket loginPacket = new LoginRequestPacket();
        loginPacket.setUserName("ddw");
        loginPacket.setUserId(UUID.randomUUID().toString());
        loginPacket.setPassWord("123456");

//        //传输的载体ByteBuf(将登录对象序列化再放入ByteBuf中)
//        //获取一个 netty 对二进制数据的抽象
//        ByteBuf byteBuf = PacketCode.INSTANCE.encode(ctx.alloc(), requestPacket);

        //发送
        //写数据
        ctx.channel().writeAndFlush(loginPacket);
    }
}