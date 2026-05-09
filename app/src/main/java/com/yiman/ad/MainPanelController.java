package com.yiman.ad;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yiman.ad.adbid.AdConfig;
import com.yiman.ad.adbid.R;
import com.yiman.ad.log.MainLogConsole;

public final class MainPanelController {

    private final MainActivity activity;

    public MainPanelController(@NonNull MainActivity activity) {
        this.activity = activity;
    }

    public void bind() {
        ScrollView logScroll = activity.findViewById(R.id.scroll_log);
        TextView logText = activity.findViewById(R.id.text_log);
        MainLogConsole.bind(logScroll, logText);
        MainLogConsole.clear();

    }

    public void unbind() {
        MainLogConsole.unbind();
    }

    public IAdLoad getCurrentAdLoad() {
        return  AdConfig.getAdLoad(activity);
    }


}
