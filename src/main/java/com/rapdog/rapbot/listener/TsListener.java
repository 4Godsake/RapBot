package com.rapdog.rapbot.listener;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.*;
import love.forte.simboot.annotation.Listener;
import love.forte.simbot.LoggerFactory;
import love.forte.simbot.LongID;
import love.forte.simbot.component.mirai.event.MiraiBotStartedEvent;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * 复读指令监听器
 * @author rapdog
 */
@Component
public class TsListener {

    private static final Logger logger = LoggerFactory.getLogger(TsListener.class);

    private static final String HOST = "www.rapdog.cn";

    private static final String SERVER_ADMIN = "serveradmin";

    private static final String PASSWORD = "6627221lt";

    private static final String BOT_NAME = "serveradmin";

    @Listener
    public void listen(MiraiBotStartedEvent event) {
        logger.info("bot started, start listening ts server");
        final TS3Config config = new TS3Config();
        config.setHost(HOST);
        config.setEnableCommunicationsLogging(true);
        final TS3Query query = new TS3Query(config);
        query.connect();
        final TS3Api api = query.getApi();
        api.login(SERVER_ADMIN, PASSWORD);
        api.selectVirtualServerById(1);
        api.registerAllEvents();
        api.addTS3Listeners(new TS3Listener() {
            @Override
            public void onTextMessage(TextMessageEvent e) {
                if ("quit".equals(e.getMessage())) {
                    query.exit();
                }
                System.out.println("Text message received in " + e.getTargetMode());
            }

            @Override
            public void onServerEdit(ServerEditedEvent e) {
                System.out.println("Server edited by " + e.getInvokerName());
            }

            @Override
            public void onClientMoved(ClientMovedEvent e) {
                System.out.println("Client has been moved " + e.getClientId());
            }

            @Override
            public void onClientJoin(ClientJoinEvent e) {
                logger.info("clientId{} just join",e.getClientId());
                logger.info("{}",e);
                if (!e.get("client_nickname").contains(BOT_NAME)){
                    Objects.requireNonNull(event.getBot().getGroup(new LongID(864386252)))
                            .sendBlocking(e.get("client_nickname")+" 进入了TS，并高呼：“英雄集结！”");
                }
            }

            @Override
            public void onClientLeave(ClientLeaveEvent e) {
                // ...
            }

            @Override
            public void onChannelEdit(ChannelEditedEvent e) {
                // ...
            }

            @Override
            public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent e) {
                // ...
            }

            @Override
            public void onChannelCreate(ChannelCreateEvent e) {
                // ...
            }

            @Override
            public void onChannelDeleted(ChannelDeletedEvent e) {
                // ...
            }

            @Override
            public void onChannelMoved(ChannelMovedEvent e) {
                // ...
            }

            @Override
            public void onChannelPasswordChanged(ChannelPasswordChangedEvent e) {
                // ...
            }

            @Override
            public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent e) {
                // ...
            }
        });
        logger.info("tsServer listener started...");
    }
}
