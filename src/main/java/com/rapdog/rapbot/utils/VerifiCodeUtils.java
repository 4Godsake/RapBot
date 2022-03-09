package com.rapdog.rapbot.utils;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class VerifiCodeUtils {

    private static String userKey;

    private static final Logger logger = LoggerFactory.getLogger(VerifiCodeUtils.class);

    private static final String LOGIN_URL = "http://www.damagou.top/apiv1/login.html?username=${username}&password=${psw}";

    private static final String CRACK_URL = "http://www.damagou.top/apiv1/recognize.html";

    private static void initUserKey(){
        logger.info("initing userKey");
        userKey = HttpUtil.get(LOGIN_URL
                .replace("${username}","1025744898@qq.com")
                .replace("${psw}","6627221lt"));
        logger.info("init userKey success : userKey:{}",userKey);
    }

    public static String getUserKey() {
        if (CharSequenceUtil.isEmpty(userKey)){
            initUserKey();
        }
        return userKey;
    }

    public static String crack(String base64Img){
        logger.info(base64Img);
        Map<String,Object> params = new HashMap<>();
        params.put("image",base64Img);
        params.put("userkey",getUserKey());
        params.put("type","1001");
        return HttpRequest.post(CRACK_URL).body(JSON.toJSONString(params)).execute().body();
    }
}
