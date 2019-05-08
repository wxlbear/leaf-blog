package xyz.bbear.leaf.im.model;

import lombok.Data;

/**
 * LoginRequestPacket.
 *
 * @author xiongliu wu 2019-05-07 19:55
 */
@Data
public class LoginRequestPacket extends Packet {

    /**
     * 用户id.
     */
    private String userId;

    /**
     * username.
     */
    private String username;

    /**
     * password.
     */
    private String password;

    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN_REQUEST.code;
    }
}
