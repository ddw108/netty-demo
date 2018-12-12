package message.protocol;

import lombok.Data;

import static message.protocol.Command.LOGIN_RESPONSE;

/**
 * 相应的Packet
 *
 * @author dengdingwwen
 * @version $Id: LoginResponsePacket.java,v 1.0 2018/12/10 10:02 dengdingwwen
 * @date 2018/12/10 10:02
 */
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;

    private String userId;

    private String userName;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}