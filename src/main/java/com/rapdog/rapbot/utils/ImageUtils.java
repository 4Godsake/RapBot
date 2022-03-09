package com.rapdog.rapbot.utils;


import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author rapdog
 */
public class ImageUtils {

    private static final String PNG_HEADER = "data:image/png;base64,";

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath
     */
    public static String convertFileToBase64(File imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try(InputStream in = new FileInputStream(imgPath)) {
            System.out.println("文件大小（字节）="+in.available());
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();

        String b64 = encoder.encode(data);
        b64 = PNG_HEADER + b64.replaceAll("\\r|\\n","");
        return b64;
    }

}
