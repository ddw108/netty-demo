package Client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 对于客户端的启动来说，
 * 和服务端的启动类似，
 * 依然需要线程模型、IO 模型，以及 IO 业务处理逻辑三大参数
 *
 * @author dengdingwwen
 * @version $Id: NettyClient.java,v 1.0 2018/12/6 15:21 dengdingwwen
 * @date 2018/12/6 15:21
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {

        //客户端引导类
        Bootstrap bootstrap = new Bootstrap();

        //客户端线程组
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap
                //指定线程模型
                .group(group)
                //指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
                //IO 处理逻辑
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });

        //建立连接
        Channel channel = connect(bootstrap, "127.0.0.1", 8001, 10);

        while (true) {
            channel.writeAndFlush(new Date() + ": hello world!");
            Thread.sleep(2000);
        }
    }

    private static Channel connect(Bootstrap bootstrap, String host, int port, int retry) {
        Channel channel = bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (10 - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit
                        .SECONDS);
            }
        }).channel();
        return channel;
    }
}