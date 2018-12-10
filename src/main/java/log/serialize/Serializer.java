package log.serialize;

import log.serialize.impl.JSONSerializer;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: Serializer.java,v 1.0 2018/12/10 10:03 dengdingwwen
 * @date 2018/12/10 10:03
 */
public interface Serializer {

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

    Serializer DEFAULT = new JSONSerializer();
}