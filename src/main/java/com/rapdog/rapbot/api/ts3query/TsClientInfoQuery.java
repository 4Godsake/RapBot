package com.rapdog.rapbot.api.ts3query;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TsClientInfoQuery {

    private static final Logger logger = LoggerFactory.getLogger(TsClientInfoQuery.class);

    private static final String HOST = "www.rapdog.cn";

    private static final String SERVER_ADMIN = "serveradmin";

    private static final String PASSWORD = "6627221lt";

    private static final String BOT_NAME = "serveradmin";

    public static String getClients(){
        logger.info("init ts3bot");
        final TS3Config config = new TS3Config();
        config.setHost(HOST);
        config.setEnableCommunicationsLogging(true);
        final TS3Query query = new TS3Query(config);
        logger.info("connect query start");
        query.connect();
        logger.info("connect query end");
        final TS3Api api = query.getApi();
        logger.info("login ...");
        api.login(SERVER_ADMIN, PASSWORD);
        logger.info("login success");
        api.selectVirtualServerById(1);
        logger.info("api query start....");
        List<Channel> channels = api.getChannels();
        List<Client> clientList = api.getClients();
        logger.info("api query end");
        Map<Integer, Channel> channelMap = new HashMap<>(channels.size());
        for (Channel channel : channels) {
            channelMap.put(channel.getId(), channel);
        }
        StringBuilder resp = new StringBuilder("当前TS在线人数：${num}");
        int num = clientList.size();

        // List all clients in the console
        for (Client c : clientList) {
            // Get the client's channel
            Channel channel = channelMap.get(c.getChannelId());

            // Write the client and channel name into the console
            if (!c.getNickname().contains(BOT_NAME)){
                resp.append("\n").append(c.getNickname()).append(" in channel ").append(channel.getName());
            }else{
                num = num -1;
            }
        }
        // We're done, disconnect
        query.exit();
        return resp.toString().replace("${num}",String.valueOf(num));
    }
}
