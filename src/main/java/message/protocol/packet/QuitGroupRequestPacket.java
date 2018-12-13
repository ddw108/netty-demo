package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.QUIT_GROUP_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: QuitGroupRequestPacket.java,v 1.0 2018/12/13 14:42 dengdingwwen
 * @date 2018/12/13 14:42
 */
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}