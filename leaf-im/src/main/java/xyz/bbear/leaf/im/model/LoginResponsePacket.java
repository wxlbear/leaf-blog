package xyz.bbear.leaf.im.model;

import lombok.Data;

/**
 * LoginResponsePacket.
 *
 * @author xiongliu wu 2019-05-08 19:48
 */
@Data
public class LoginResponsePacket extends Packet {

    /**
     * login result.
     */
    private boolean success;

    /**
     * login failed reason.
     */
    private String reason;


    @Override
    public Byte getCommand() {
        return CommandEnum.LOGIN_RESPONSE.code;
    }
}
