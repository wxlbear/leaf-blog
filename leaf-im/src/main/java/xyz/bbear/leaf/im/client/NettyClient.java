package xyz.bbear.leaf.im.client;

import java.util.Date;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

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
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch){
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();
        while (true){
            channel.writeAndFlush(new Date() + ": hello world!");
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}
