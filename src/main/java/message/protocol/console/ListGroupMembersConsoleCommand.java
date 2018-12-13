package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.ListGroupMembersRequestPacket;

import java.util.Scanner;

/**
 * 显示组成员的控制台命令
 *
 * @author dengdingwwen
 * @version $Id: ListGroupMembersConsoleCommand.java,v 1.0 2018/12/13 14:58 dengdingwwen
 * @date 2018/12/13 14:58
 */
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {

        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();
        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();
        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}