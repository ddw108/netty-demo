package message;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import message.handler.*;

import java.util.Date;

/**
 * 创建一个引导类，
 * 然后给他指定线程模型，IO模型，连接读写处理逻辑，绑定端口之后，
 * 服务端就启动起来了。
 *
 * @author dengdingwwen
 * @version $Id: NettyService.java,v 1.0 2018/12/10 11:39 dengdingwwen
 * @date 2018/12/10 11:39
 */
public class NettyService {

    private static final int PORT = 8001;

    public static void main(String[] args) {

        //boss线程组监听端口，accept新连接的线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //worker线程组处理每一条连接的数据读写
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //服务端引导类
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                //配置两大线程组
                .group(bossGroup, workerGroup)
                //指定IO模型，这里为NIO模型
                .channel(NioServerSocketChannel.class)
                //设置TCP底层数据
                //连接超时时间
                .option(ChannelOption.SO_BACKLOG, 1024)
                //底层心跳机制
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //实时性相关
                .childOption(ChannelOption.TCP_NODELAY, true)
                //childHandler()用于指定处理新连接数据的读写处理逻辑
                //handler()用于指定在服务端启动过程中的一些逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        //指定连接数据读写逻辑
                        //服务端
                        // 校验+解决粘包处理器
                        ch.pipeline().addLast(new VerifyHandler());
                        //ch.pipeline().addLast(new LifeCyCleTestHandler());
                        //ch.pipeline().addLast(new StickyRequestHandler());
                        // 解码处理器
                        ch.pipeline().addLast(new DecoderHandler());
                        // 登录请求处理器
                        ch.pipeline().addLast(new LoginRequestHandler());
                        // 判断是否登录处理器
                        ch.pipeline().addLast(new AuthHandler());
                        // 单聊消息请求处理器
                        ch.pipeline().addLast(new MessageRequestHandler());
                        // 创建群请求处理器
                        ch.pipeline().addLast(new CreateGroupRequestHandler());
                        // 加群请求处理器
                        ch.pipeline().addLast(new JoinGroupRequestHandler());
                        // 退群请求处理器
                        ch.pipeline().addLast(new QuitGroupRequestHandler());
                        // 获取群成员请求处理器
                        ch.pipeline().addLast(new ListGroupMembersRequestHandler());
                        // 登出请求处理器
                        ch.pipeline().addLast(new LogoutRequestHandler());
                        // 编码处理器
                        ch.pipeline().addLast(new EncoderHandler());
                    }
                });
        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {

        serverBootstrap
                //监听某个端口，返回值是一个ChannelFuture，是一个异步方法
                .bind(port)
                // 用来返回端口是否绑定成功
                .addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }
}