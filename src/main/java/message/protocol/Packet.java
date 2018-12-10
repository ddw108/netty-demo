package message.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Packet的抽象类（相当于Type的父类）
 *
 * @author dengdingwwen
 * @version $Id: Packet.java,v 1.0 2018/12/10 9:52 dengdingwwen
 * @date 2018/12/10 9:52
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();
 }