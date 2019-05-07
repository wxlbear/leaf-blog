package xyz.bbear.leaf.im.model;

import com.alibaba.fastjson.JSON;

/**
 * JSONSerializer.
 *
 * @author xiongliu wu 2019-05-07 20:00
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
