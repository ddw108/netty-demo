package message.protocol.packet;

import message.protocol.Packet;

import static message.protocol.Command.LOGOUT_REQUEST;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LogoutRequestPacket.java,v 1.0 2018/12/13 9:59 dengdingwwen
 * @date 2018/12/13 9:59
 */
public class LogoutRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}