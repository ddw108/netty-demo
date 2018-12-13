package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.CreateGroupRequestPacket;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: CreateGroupConsoleCommand.java,v 1.0 2018/12/13 9:52 dengdingwwen
 * @date 2018/12/13 9:52
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");
        String userIds = scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(",")));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}