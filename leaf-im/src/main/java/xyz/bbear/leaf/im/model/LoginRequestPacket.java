package xyz.bbear.leaf.im.model;

import lombok.Data;

/**
 * LoginRequestPacket.
 *
 * @author xiongliu wu 2019-05-07 19:55
 */
@Data
public class LoginRequestPacket extends Packet {

    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
