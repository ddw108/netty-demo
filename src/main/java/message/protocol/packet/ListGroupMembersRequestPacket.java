package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ListGroupMembersRequestPacket.java,v 1.0 2018/12/13 14:55 dengdingwwen
 * @date 2018/12/13 14:55
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}