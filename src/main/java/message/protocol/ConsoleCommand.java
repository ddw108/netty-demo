package message.protocol;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ConsoleCommand.java,v 1.0 2018/12/13 9:45 dengdingwwen
 * @date 2018/12/13 9:45
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}