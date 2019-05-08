package xyz.bbear.leaf.im.handler;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import xyz.bbear.leaf.im.model.LoginRequestPacket;
import xyz.bbear.leaf.im.model.LoginResponsePacket;
import xyz.bbear.leaf.im.model.Packet;
import xyz.bbear.leaf.im.model.PacketCodec;

/**
 * ServerHandler.
 *
 * @author xiongliu wu 2019-05-08 19:28
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("receive msg : " + byteBuf.toString(Charset.forName("utf-8")));
        Packet packet = PacketCodec.decode(byteBuf);
        if(packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            // 登录校验
            if (valid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
            } else {
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setReason("账号密码校验失败");
            }

            ByteBuf response = PacketCodec.encode(loginResponsePacket);
            ctx.channel().writeAndFlush(response);
        }

    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
