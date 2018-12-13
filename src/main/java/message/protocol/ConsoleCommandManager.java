package message.protocol;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.console.CreateGroupConsoleCommand;
import message.protocol.console.LogoutConsoleCommand;
import message.protocol.console.SendToUserConsoleCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: ConsoleCommandManager.java,v 1.0 2018/12/13 9:48 dengdingwwen
 * @date 2018/12/13 9:48
 */
public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager(){
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String command = scanner.next();
        ConsoleCommand consoleCommand = consoleCommandMap.get(command);
        if(consoleCommand != null){
            consoleCommand.exec(scanner, channel);
        }else{
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}