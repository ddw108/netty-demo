package message.protocol.packet;

import lombok.Data;
import message.protocol.Packet;

import static message.protocol.Command.LOGIN_REQUEST;

/**
 * 请求的Packet
 *
 * @author dengdingwwen
 * @version $Id: LoginRequestPacket.java,v 1.0 2018/12/10 9:58 dengdingwwen
 * @date 2018/12/10 9:58
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String userName;

    private String passWord;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}