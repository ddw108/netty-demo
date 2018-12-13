package message.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import message.protocol.packet.CreateGroupRequestPacket;
import message.protocol.packet.CreateGroupResponsePacket;
import message.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: CreateGroupRequestHandler.java,v 1.0 2018/12/13 10:19 dengdingwwen
 * @date 2018/12/13 10:19
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
        List<String> userIdList = msg.getUserIdList();
        List<String> usernameList = new ArrayList<>();
        // 1. 创建一个 channel 分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        // 2. 筛选出待加入群聊的用户的 channel 和 userName
        for(String userId : userIdList){
            Channel channel = SessionUtil.getChannel(userId);
            if(channel != null){
                channelGroup.add(channel);
                usernameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }
        // 3. 创建群聊创建结果的响应
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(UUID.randomUUID().toString().split("-")[0]);
        createGroupResponsePacket.setUserNameList(usernameList);
        // 4. 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);
        System.out.print("群创建成功，id 为[" + createGroupResponsePacket.getGroupId() + "], ");
        System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());
    }
}