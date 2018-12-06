package Service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * 创建一个引导类，
 * 然后给他指定线程模型，IO模型，连接读写处理逻辑，绑定端口之后，
 * 服务端就启动起来了。
 *
 * @author dengdingwwen
 * @version $Id: NettyServer.java,v 1.0 2018/12/6 15:09 dengdingwwen
 * @date 2018/12/6 15:09
 */
public class NettyServer {

    private static final int PORT = 8001;

    public static void main(String[] args) {

        //服务端引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //boss线程组监听端口，accept新连接的线程组
        NioEventLoopGroup boss = new NioEventLoopGroup();
        //worker线程组处理每一条连接的数据读写
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                //配置两大线程组
                .group(boss, worker)
                //指定IO模型，这里为NIO模型
                .channel(NioServerSocketChannel.class)
                //childHandler()用于指定处理新连接数据的读写处理逻辑
                //handler()用于指定在服务端启动过程中的一些逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    //跟NIO有关的服务启动初始化方法的实现
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            //重写读动作
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                });
        bind(serverBootstrap, 8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {

        //监听某个端口，返回值是一个ChannelFuture，是一个异步方法
        serverBootstrap
                .bind(port)
                // 用来返回端口是否绑定成功
                .addListener(future -> {
                    if (future.isSuccess()) {
                        System.out.println(port + " : 端口绑定成功!");
                    } else {
                        //如果绑定失败，继续找下一个可以绑定的端口
                        System.out.println(port + " : 端口绑定失败!");
                        bind(serverBootstrap, port + 1);
                    }
                });
    }
}