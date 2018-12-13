package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import java.util.List;

import static message.protocol.Command.CREATE_GROUP_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: CreateGroupResponsePacket.java,v 1.0 2018/12/13 10:05 dengdingwwen
 * @date 2018/12/13 10:05
 */
@Data
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}