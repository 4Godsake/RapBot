package com.rapdog.rapbot.api;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author rapdog
 *
 * 历史上的今天
 */
public class TodayInHistoryApi {

    private static final String URL = "https://www.ipip5.com/today/api.php?type=json";

    private static final Logger logger = LoggerFactory.getLogger(TodayInHistoryApi.class);

    public static String getTodayInHistory(){
        String jsonStr = HttpRequest.post(URL)
                .header(Header.ACCEPT,"*/*")
                .header(Header.ACCEPT_ENCODING,"gzip, deflate, br")
                .header(Header.CONNECTION,"keep-alive")
                .header(Header.USER_AGENT,"PostmanRuntime/7.29.0").execute().body();
        logger.info(jsonStr);
        Map<String, Object> map = JSON.parseObject(jsonStr);
        List<Map<String, String>> result = (List<Map<String, String>>) map.get("result");
        StringBuilder sb = new StringBuilder("【历史上的今天】");
        sb.append(map.get("today"));
        result.forEach(rst ->{
            if (!rst.get("title").contains("www.ipip5.com")){
                sb.append("\n").append(rst.get("year")).append("年：").append(rst.get("title"));
            }
        });
        return sb.toString();
    }
}
