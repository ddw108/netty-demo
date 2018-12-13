package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.JoinGroupRequestPacket;

import java.util.Scanner;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: JoinGroupConsoleCommand.java,v 1.0 2018/12/13 14:18 dengdingwwen
 * @date 2018/12/13 14:18
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();
        System.out.println("输入 groupId，加入群聊：");
        String groupId = scanner.next();
        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}