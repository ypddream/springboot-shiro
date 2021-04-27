package com.example.shiro.utils;

import java.util.Random;

/**
 * ClassName:SaltUtil
 * Package:com.example.shiro.utils
 * Description:TODO
 *
 * @Date:2021/4/26 0026 下午 3:37
 * @author:ypd
 */
public class SaltUtil {
    /**
     * 生成salt的静态方法
     * @param n salt的个数
     * @return
     */
    public static String getSalt(int n) {

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWSYZabcdefghijklmnopqrstuvwsyz0123456789-+!@#$%()".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(aChar);
        }

        return stringBuilder.toString();

    }

}
