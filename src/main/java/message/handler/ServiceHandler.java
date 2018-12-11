package message.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import message.protocol.*;

import java.util.Date;

/**
 * 服务端配置
 *
 * @author dengdingwwen
 * @version $Id: ServiceHandler.java,v 1.0 2018/12/10 11:38 dengdingwwen
 * @date 2018/12/10 11:38
 */
public class ServiceHandler extends ChannelInboundHandlerAdapter {

    //接收到客户端发来的数据之后被回调
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;

        Packet packet = PacketCode.INSTANCE.decode(requestByteBuf);

        if (packet instanceof LoginRequestPacket) {

        }else if(packet instanceof MessageRequestPacket){

        }
    }


}