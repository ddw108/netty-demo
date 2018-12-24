package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;
import message.util.Session;

import static message.protocol.Command.GROUP_MESSAGE_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: GroupMessageResponsePacket.java,v 1.0 2018/12/14 15:23 dengdingwwen
 * @date 2018/12/14 15:23
 */
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private String message;

    private Session fromUser;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}