package xyz.bbear.leaf.im.util;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import xyz.bbear.leaf.im.model.Attributes;

/**
 * LoginUtil.
 *
 * @author xiongliu wu 2019-05-15 21:19
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
