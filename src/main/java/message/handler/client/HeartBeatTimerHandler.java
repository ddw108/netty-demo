package message.handler.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import message.protocol.packet.HeartBeatRequestPacket;

import java.util.concurrent.TimeUnit;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: HeartBeatTimerHandler.java,v 1.0 2018/12/24 14:34 dengdingwwen
 * @date 2018/12/24 14:34
 */
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //每个一段时间发送一个packet
        scheduleSendHeartBeat(ctx);
        super.channelActive(ctx);
    }

    private void scheduleSendHeartBeat(ChannelHandlerContext ctx){
        ctx.executor().schedule(()->{
            if(ctx.channel().isActive()){
                ctx.writeAndFlush(new HeartBeatRequestPacket());
                scheduleSendHeartBeat(ctx);
            }
        }, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
    }
}