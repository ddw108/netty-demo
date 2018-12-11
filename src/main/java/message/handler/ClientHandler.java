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

    }

    //接收到服务端发来的数据之后被回调
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }
}