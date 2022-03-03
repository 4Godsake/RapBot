package com.rapdog.rapbot.commands;

import com.rapdog.rapbot.constants.CommandConstants;
import com.rapdog.rapbot.service.CustomCommandService;
import com.rapdog.rapbot.utils.SpringUtil;
import love.forte.simbot.component.mirai.event.MiraiGroupMessageEvent;
import love.forte.simbot.component.mirai.event.MiraiReceivedMessageContent;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义回复指令（customCommand）
 * @author rapdog
 */
public class ReplyBaseCommand extends BaseCommand {

    private static final String ADD = "add";

    private static final String REMOVE = "remove";

    private static final String GLOBAL = "global";

    private static final int MIN_ARGS = 2;

    public ReplyBaseCommand(MiraiGroupMessageEvent event){
        this.setEvent(event);
        // 指令配置
        this.setCommandString(CommandConstants.REPLY);
        this.setCommandDesc("自定义回复指令");
        // 截取指令参数
        MiraiReceivedMessageContent messageContent = event.getMessageContent();
        MessageChain nativeMessageChain = messageContent.getNativeMessageChain();
        String[] commandStr = nativeMessageChain.contentToString().split(" ");
        List<String> commandArgs = Arrays.asList(commandStr).subList(1,commandStr.length);
        this.setCommandArgs(commandArgs);
    }

    @Override
    public void doCommand() {
        List<String> args = this.getCommandArgs();
        String result = "";
        if (args.size() < MIN_ARGS) {
            result = "指令缺少参数";
        }else{
            if (ADD.equalsIgnoreCase(args.get(0))){
                result = add(args);
            }else if (REMOVE.equalsIgnoreCase(args.get(0))){
                result = remove(args);
            }
        }
        this.getEvent().sendBlocking(result);
    }

    private String add(List<String> args){
        /*
            /reply add 你好 你也好 global
                   0   1   2     3
         */
        // in this case supposed to be 你好
        String commandStr = args.get(1);
        // in this case supposed to be 你也好
        String replyMessage = args.get(2);
        // in this case supposed to be "global"(can be null)
        String arg3 = args.size() > 3 ? args.get(3) : null;
        // creatorId
        Long creatorId = this.getEvent().getAuthor().getId().getValue();
        // default: 当前群Id，传global会覆盖
        Long activeGroupId = GLOBAL.equalsIgnoreCase(arg3) ? null : this.getEvent().getGroup().getId().getValue();
        return SpringUtil.getBean(CustomCommandService.class).bindCustomCommand(commandStr,replyMessage,creatorId,activeGroupId);
    }

    private String remove(List<String> args){
        /*
            /reply remove 你好
                   0      1
         */
        // in this case supposed to be 你好
        String commandStr = args.get(1);
        return SpringUtil.getBean(CustomCommandService.class).unbindCustomCommand(commandStr);
    }

}
