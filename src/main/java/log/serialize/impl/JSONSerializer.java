package log.serialize.impl;

import com.alibaba.fastjson.JSON;
import log.serialize.Serializer;
import log.serialize.SerializerAlgorithm;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: JSONSerializer.java,v 1.0 2018/12/10 10:14 dengdingwwen
 * @date 2018/12/10 10:14
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {

        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}