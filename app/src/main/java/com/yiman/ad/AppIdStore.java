package com.yiman.ad;

import androidx.annotation.NonNull;

public final class AppIdStore {

    private static final String KEY_APP_ID_ADBID = "app_id_adbid";
    private static final String KEY_APP_ID_ADX = "app_id_adx";

    private AppIdStore() {
    }

    @NonNull public static String getSelectedAppId(boolean isAdxMode) {
        return "10005";
    }

}
