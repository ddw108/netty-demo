package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.LOGOUT_RESPONSE;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LogoutResponsePacket.java,v 1.0 2018/12/13 10:03 dengdingwwen
 * @date 2018/12/13 10:03
 */
@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}