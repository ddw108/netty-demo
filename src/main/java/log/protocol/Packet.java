package log.protocol;

import lombok.Data;

/**
 * 类注释，描述
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
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
 }