package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.JOIN_GROUP_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: JoinGroupRequestPacket.java,v 1.0 2018/12/13 14:20 dengdingwwen
 * @date 2018/12/13 14:20
 */
@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}