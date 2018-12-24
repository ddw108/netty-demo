package message.protocol.packet;

import message.protocol.Packet;

import static message.protocol.Command.HEARTBEAT_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: HeartBeatRequestPacket.java,v 1.0 2018/12/24 15:05 dengdingwwen
 * @date 2018/12/24 15:05
 */
public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }

}