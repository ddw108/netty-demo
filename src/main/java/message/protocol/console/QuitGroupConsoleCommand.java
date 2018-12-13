package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.QuitGroupRequestPacket;

import java.util.Scanner;

/**
 * 退出群聊的控制台命令
 *
 * @author dengdingwwen
 * @version $Id: QuitGroupConsoleCommand.java,v 1.0 2018/12/13 14:45 dengdingwwen
 * @date 2018/12/13 14:45
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();
        System.out.print("输入 groupId，退出群聊：");
        String groupId = scanner.next();
        quitGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}