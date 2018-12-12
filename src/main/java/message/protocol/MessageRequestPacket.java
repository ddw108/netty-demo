package message.protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

import static message.protocol.Command.MESSAGE_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: MessageRequestPacket.java,v 1.0 2018/12/10 15:38 dengdingwwen
 * @date 2018/12/10 15:38
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet{

    private String toUserId;

    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}