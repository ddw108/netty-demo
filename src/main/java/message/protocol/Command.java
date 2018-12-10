package message.protocol;

/**
 * 命令接口
 *
 * @author dengdingwwen
 * @version $Id: Command.java,v 1.0 2018/12/10 9:56 dengdingwwen
 * @date 2018/12/10 9:56
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}