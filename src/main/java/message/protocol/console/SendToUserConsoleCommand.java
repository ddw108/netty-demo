package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.MessageRequestPacket;

import java.util.Scanner;

/**
 * 单聊的控制台命令
 *
 * @author dengdingwwen
 * @version $Id: SendToUserConsoleCommand.java,v 1.0 2018/12/13 9:56 dengdingwwen
 * @date 2018/12/13 9:56
 */
public class SendToUserConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个用户：");
        String toUserId = scanner.next();
        String message =  scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}