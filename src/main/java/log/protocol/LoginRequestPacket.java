package log.protocol;

import lombok.Data;

import static log.protocol.Command.LOGIN_REQUEST;

/**
 * 类注释，描述
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