package message.attribute;

import io.netty.util.AttributeKey;
import message.util.Session;

/**
 * 是否登录成功的标志位
 *
 * @author dengdingwwen
 * @version $Id: Attributes.java,v 1.0 2018/12/10 15:50 dengdingwwen
 * @date 2018/12/10 15:50
 */
public interface Attributes {
    //channel的属性类
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
