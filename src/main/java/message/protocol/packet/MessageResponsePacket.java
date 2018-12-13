package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.MESSAGE_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: MessageResponsePacket.java,v 1.0 2018/12/10 15:38 dengdingwwen
 * @date 2018/12/10 15:38
 */
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }

    public MessageResponsePacket(String fromUserName, String message){
        this.fromUserName = fromUserName;
        this.message = message;
    }

    public MessageResponsePacket(){
    }
}