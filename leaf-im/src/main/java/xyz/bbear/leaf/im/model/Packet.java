package xyz.bbear.leaf.im.model;

import lombok.Data;

/**
 * Packet.
 *
 * @author xiongliu wu 2019-05-07 19:51
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    public abstract Byte getCommand();
}
