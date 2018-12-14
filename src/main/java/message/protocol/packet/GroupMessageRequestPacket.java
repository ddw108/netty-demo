package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.GROUP_MESSAGE_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: GroupMessageRequestPacket.java,v 1.0 2018/12/14 15:22 dengdingwwen
 * @date 2018/12/14 15:22
 */
@Data
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;

    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}