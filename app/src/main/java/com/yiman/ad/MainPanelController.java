package com.yiman.ad;

import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yiman.ad.adbid.AdbidAdLoad;
import com.yiman.ad.adbid.R;
import com.yiman.ad.log.MainLogConsole;

public final class MainPanelController {

    private final MainActivity activity;
    private final MainLogConsole logConsole = new MainLogConsole();

    public MainPanelController(@NonNull MainActivity activity) {
        this.activity = activity;
    }

    public void bind() {
        bindLogConsole(true);
    }

    public void rebindLogConsole() {
        bindLogConsole(false);
    }

    public void unbind() {
        logConsole.unbind();
    }

    @NonNull
    public MainLogConsole getLogConsole() {
        return logConsole;
    }

    public IAdLoad getCurrentAdLoad() {
        return AdbidAdLoad.getInstance(activity, logConsole);
    }

    private void bindLogConsole(boolean clearLogs) {
        ScrollView logScroll = activity.findViewById(R.id.scroll_log);
        TextView logText = activity.findViewById(R.id.text_log);
        logConsole.bind(logScroll, logText);
        if (clearLogs) {
            logConsole.clear();
        }
    }
}
