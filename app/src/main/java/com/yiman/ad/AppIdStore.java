package com.yiman.ad;

import androidx.annotation.NonNull;

import com.yiman.ad.adbid.AdConfig;
import com.yiman.ad.utils.PreferencesUtils;

public final class AppIdStore {

    private static final String KEY_APP_ID_ADBID = "app_id_adbid";
    private static final String KEY_APP_ID_ADX = "app_id_adx";

    private AppIdStore() {
    }

    @NonNull public static String getSelectedAppKey() {

        String cached = PreferencesUtils.getString(KEY_APP_ID_ADBID, "");
        return AdConfig.resolveSelectionKey(cached);
    }

    @NonNull public static String getSelectedAppId() {
        return AdConfig.resolveAppId(getSelectedAppKey());
    }

    public static void saveSelectedAppId(@NonNull String appId) {
        PreferencesUtils.put(KEY_APP_ID_ADBID, AdConfig.resolveSelectionKey(appId));
    }
}
