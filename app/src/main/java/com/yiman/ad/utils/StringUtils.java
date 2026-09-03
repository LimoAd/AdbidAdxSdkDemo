package com.yiman.ad.utils;

/**
 * Demo 字符串工具，不依赖 SDK 内部 StringUtils。
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * 判断给定字符串是否为空（null、空串或仅空白）。
     */
    public static boolean isEmpty(String obj) {
        return obj == null || obj.trim().isEmpty();
    }
}
