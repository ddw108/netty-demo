package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.JOIN_GROUP_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: JoinGroupResponsePacket.java,v 1.0 2018/12/13 14:21 dengdingwwen
 * @date 2018/12/13 14:21
 */
@Data
public class JoinGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}