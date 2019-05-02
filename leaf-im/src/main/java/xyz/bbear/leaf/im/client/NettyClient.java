package xyz.bbear.leaf.im.client;

import java.nio.charset.Charset;
import java.util.Date;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import xyz.bbear.leaf.im.handler.FirstClientHandler;

/**
 * NettyClient.
 *
 * @author xiongliu wu 2019-05-02 13:41
 */
public class NettyClient {
    public static void start() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch){
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();
        while (true){
            System.out.println("*****");
            ByteBuf buffer = channel.alloc().buffer();
            byte[] bytes = "你好，闪电侠！".getBytes(Charset.forName("utf-8"));
            buffer.writeBytes(bytes);
            channel.writeAndFlush(buffer);
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}
