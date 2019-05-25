package xyz.bbear.leaf.im.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Command.
 *
 * @author xiongliu wu 2019-05-07 19:55
 */
public enum  CommandEnum {
    LOGIN_REQUEST((byte)1, LoginRequestPacket.class),
    LOGIN_RESPONSE((byte)2, LoginResponsePacket.class),
    MESSAGE_REQUEST((byte)3, MessageRequestPacket.class),
    MESSAGE_RESPONSE((byte)4, MessageResponsePacket.class);

    public final Byte code;
    public final Class<? extends Packet> type;

    CommandEnum(Byte code, Class<? extends Packet> type) {
        this.code = code;
        this.type = type;
    }

    /**
     * get command type Map.
     * @return map
     */
    public static Map<Byte, Class<? extends Packet>> typeMap(){
        Map<Byte, Class<? extends Packet>> map = new HashMap<>();
        for (CommandEnum value : CommandEnum.values()) {
            map.put(value.code, value.type);
        }
        return map;
    }
}
