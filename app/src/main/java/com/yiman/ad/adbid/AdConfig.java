package com.yiman.ad.adbid;

import android.content.Context;

import androidx.annotation.NonNull;

import com.yiman.ad.AppIdStore;
import com.yiman.ad.IAdLoad;
import com.yiman.ad.log.MainLogConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class AdConfig {
    private String appId;
    private final String splashUnitId;

    public static final String DEFAULT_APP_ID = "10005";
    private static final Map<String, AdConfig> configMap = new HashMap<>();

    private static boolean s2sBiddingEnabled = false;

    public static boolean isS2SBiddingEnabled() {
        return s2sBiddingEnabled;
    }

    public static void setS2SBiddingEnabled(boolean enabled) {
        s2sBiddingEnabled = enabled;
    }


    static {
        configMap.put("10005", new AdConfig("10005", "MTc1MzkzMDY5NDkyOA=="));
    }

    public static IAdLoad getAdLoad(@NonNull Context context, @NonNull MainLogConsole logConsole) {
        return AdbidAdLoad.getInstance(context, logConsole);
    }

    @NonNull
    public static String resolveSelectionKey(String appId) {
        if (appId != null && configMap.containsKey(appId)) {
            return appId;
        }
        return DEFAULT_APP_ID;
    }


    @NonNull
    public static String resolveAppId(String appId) {
        return configMap.get(resolveSelectionKey(appId)).appId;
    }

    @NonNull
    public static List<String> getAvailableAppIds() {
        return new ArrayList<>(configMap.keySet());
    }

    public static AdConfig getAdConfig() {
        String selected = AppIdStore.getSelectedAppKey();
        return configMap.get(resolveSelectionKey(selected));
    }

    public AdConfig(String appId, String splashUnitId) {
        this.appId = appId;
        this.splashUnitId = splashUnitId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


    public String getSplashUnitId() {
        return splashUnitId;
    }


    @NonNull
    @Override
    public String toString() {
        return "AdConfig{" + "appId='" + appId + '\'' + ", splashUnitId='" + splashUnitId + '\'' + '}';
    }
}
