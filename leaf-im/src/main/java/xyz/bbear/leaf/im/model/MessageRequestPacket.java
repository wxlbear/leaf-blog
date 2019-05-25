package xyz.bbear.leaf.im.model;

import lombok.Data;

/**
 * MessageRequestPacket.
 *
 * @author xiongliu wu 2019-05-15 12:49
 */
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return CommandEnum.MESSAGE_REQUEST.code;
    }
}
