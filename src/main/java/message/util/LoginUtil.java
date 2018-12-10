package message.util;


import io.netty.channel.Channel;
import io.netty.util.Attribute;
import message.attribute.Attributes;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LoginUtil.java,v 1.0 2018/12/10 16:24 dengdingwwen
 * @date 2018/12/10 16:24
 */
public class LoginUtil {

    public static void markAsLogin(Channel channel){
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return loginAttr.get() != null;
    }
}