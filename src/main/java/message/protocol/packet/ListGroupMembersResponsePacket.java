package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;
import message.util.Session;

import java.util.List;

import static message.protocol.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ListGroupMembersResponsePacket.java,v 1.0 2018/12/13 14:56 dengdingwwen
 * @date 2018/12/13 14:56
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}