package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.LogoutRequestPacket;

import java.util.Scanner;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: LogoutConsoleCommand.java,v 1.0 2018/12/13 9:59 dengdingwwen
 * @date 2018/12/13 9:59
 */
public class LogoutConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}