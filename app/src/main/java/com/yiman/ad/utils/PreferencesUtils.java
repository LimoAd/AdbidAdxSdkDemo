package com.yiman.ad.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.yiman.ad.MyApplication;

import java.util.Set;

/**
 * Demo 本地 SharedPreferences 工具，不依赖 SDK 内部 SP 封装。
 */
public final class PreferencesUtils {

    private static final String PREFS_SUFFIX = "ad_bid_share_preference_config";

    private static SharedPreferences sPrefs;

    private PreferencesUtils() {
    }

    private static SharedPreferences getPreferences() {
        if (sPrefs == null) {
            Context context = MyApplication.myApplication;
            sPrefs = context.getSharedPreferences(
                    context.getPackageName() + PREFS_SUFFIX, Context.MODE_PRIVATE);
        }
        return sPrefs;
    }

    public static void put(String key, Object value) {
        if (key == null || value == null) {
            return;
        }
        SharedPreferences.Editor editor = getPreferences().edit();
        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            @SuppressWarnings("unchecked")
            Set<String> stringSet = (Set<String>) value;
            editor.putStringSet(key, stringSet);
        } else {
            return;
        }
        editor.apply();
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    public static String getString(String key) {
        return getString(key, "");
    }

    public static String getString(String key, String defValue) {
        return getPreferences().getString(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    public static float getFloat(String key, float defValue) {
        return getPreferences().getFloat(key, defValue);
    }

    public static void remove(String key) {
        getPreferences().edit().remove(key).apply();
    }

    public static boolean contains(String key) {
        return getPreferences().contains(key);
    }

    public static void clear() {
        getPreferences().edit().clear().apply();
    }
}
