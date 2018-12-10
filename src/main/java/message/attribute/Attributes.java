package message.attribute;

import io.netty.util.AttributeKey;

/**
 * 是否登录成功的标志位
 *
 * @author dengdingwwen
 * @version $Id: Attributes.java,v 1.0 2018/12/10 15:50 dengdingwwen
 * @date 2018/12/10 15:50
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
