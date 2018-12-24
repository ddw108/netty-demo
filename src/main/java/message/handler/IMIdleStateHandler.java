package message.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: IMIdleStateHandler.java,v 1.0 2018/12/24 14:27 dengdingwwen
 * @date 2018/12/24 14:27
 */
public class IMIdleStateHandler extends IdleStateHandler {

    private static final int READER_IDLE_TIME = 15;

    public IMIdleStateHandler() {
        //读空闲时间、写空闲时间、读写空闲时间、时间单位
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    // 连接假死之后会回调这个方法
    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        ctx.channel().close();
    }
}