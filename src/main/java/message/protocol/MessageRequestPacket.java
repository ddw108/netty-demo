package message.protocol;

import lombok.Data;

import static message.protocol.Command.MESSAGE_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: MessageRequestPacket.java,v 1.0 2018/12/10 15:38 dengdingwwen
 * @date 2018/12/10 15:38
 */
@Data
public class MessageRequestPacket extends Packet{

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}