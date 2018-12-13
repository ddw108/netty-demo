package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.QUIT_GROUP_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: QuitGroupResponsePacket.java,v 1.0 2018/12/13 14:43 dengdingwwen
 * @date 2018/12/13 14:43
 */
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}