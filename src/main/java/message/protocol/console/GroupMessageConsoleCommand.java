package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.GroupMessageRequestPacket;

import java.util.Scanner;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: GroupMessageConsoleCommand.java,v 1.0 2018/12/14 15:29 dengdingwwen
 * @date 2018/12/14 15:29
 */
public class GroupMessageConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        GroupMessageRequestPacket groupMessageRequestPacket = new GroupMessageRequestPacket();
        System.out.print("【发送群聊】输入 groupId，群聊消息，之间空格隔开：");
        groupMessageRequestPacket.setToGroupId(scanner.next());
        groupMessageRequestPacket.setMessage(scanner.next());
        channel.writeAndFlush(groupMessageRequestPacket);
    }
}