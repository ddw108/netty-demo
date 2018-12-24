package message.protocol.packet;

import message.protocol.Packet;

import static message.protocol.Command.HEARTBEAT_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: HeartBeatResponsePacket.java,v 1.0 2018/12/24 15:21 dengdingwwen
 * @date 2018/12/24 15:21
 */
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }

}