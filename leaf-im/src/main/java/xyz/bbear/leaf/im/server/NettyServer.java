package xyz.bbear.leaf.im.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import xyz.bbear.leaf.im.handler.FirstServerHandler;

/**
 * NettyServer.
 *
 * @author xiongliu wu 2019-05-02 13:42
 */
public class NettyServer {
    public static void listen(){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
       // 负责监听端口，accept 新连接线程
        NioEventLoopGroup boss = new NioEventLoopGroup();
        // 处理每条连接的数据读写线程组
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap.group(boss, worker)
                // 指定IO模型 为NIO
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel channel){
                        channel.pipeline().addLast(new FirstServerHandler());
//                        channel.pipeline().addLast(new StringDecoder());
//                        channel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
//                            @Override
//                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
//                                System.out.println(msg);
//                            }
//                        });
                    }
                }).bind(8000);
    }

    public static void main(String[] args) {
        listen();
    }
}
