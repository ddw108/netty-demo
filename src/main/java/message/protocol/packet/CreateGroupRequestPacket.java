package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import java.util.List;

import static message.protocol.Command.CREATE_GROUP_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: CreateGroupRequestPacket.java,v 1.0 2018/12/13 10:04 dengdingwwen
 * @date 2018/12/13 10:04
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}