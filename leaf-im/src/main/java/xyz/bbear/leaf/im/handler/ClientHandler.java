package xyz.bbear.leaf.im.handler;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import xyz.bbear.leaf.im.model.LoginRequestPacket;
import xyz.bbear.leaf.im.model.LoginResponsePacket;
import xyz.bbear.leaf.im.model.Packet;
import xyz.bbear.leaf.im.model.PacketCodec;

/**
 * ClientHandler.
 *
 * @author xiongliu wu 2019-05-08 19:27
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + " : client login");
        LoginRequestPacket requestPacket = new LoginRequestPacket();
        requestPacket.setUserId(UUID.randomUUID().toString());
        requestPacket.setUsername("wuxiongliu");
        requestPacket.setPassword("123456");

        ByteBuf byteBuf = PacketCodec.encode(requestPacket);
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        System.out.println("receive from server :" + byteBuf.toString(Charset.forName("utf-8")));

        Packet packet = PacketCodec.decode(byteBuf);
        if(packet instanceof LoginResponsePacket){
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            if(loginResponsePacket.isSuccess()){
                System.out.println(new Date() +"客户端登录成功");
            } else {
                System.out.println(new Date() +"客户端登录失败, 原因 " + loginResponsePacket.getReason());
            }
        }
    }
}
