package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import message.protocol.LoginRequestPacket;
import message.protocol.LoginResponsePacket;
import message.protocol.PacketCode;

import java.util.Date;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LoginResquestHandler.java,v 1.0 2018/12/11 11:55 dengdingwwen
 * @date 2018/12/11 11:55
 */
public class LoginResquestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket packet) throws Exception {
        System.out.println(new Date() + ": 客户端开始登录……");
        // 登录流程
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(packet)) {
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}