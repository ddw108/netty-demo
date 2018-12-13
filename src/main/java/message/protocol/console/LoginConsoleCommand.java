package message.protocol.console;

import io.netty.channel.Channel;
import message.protocol.ConsoleCommand;
import message.protocol.packet.LoginRequestPacket;

import java.util.Scanner;

/**
 * 登录的控制台命令
 *
 * @author dengdingwwen
 * @version $Id: LoginConsoleCommand.java,v 1.0 2018/12/13 9:53 dengdingwwen
 * @date 2018/12/13 9:53
 */
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.print("输入用户名登录: ");
        loginRequestPacket.setUserName(scanner.nextLine());
        // 密码使用默认的
        loginRequestPacket.setPassWord("pwd");

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}