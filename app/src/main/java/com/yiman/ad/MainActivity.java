package com.yiman.ad;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.yiman.ad.adbid.AdbidAdLoad;
import com.yiman.ad.adbid.R;
import com.yiman.ad.adbid.view.TitleBar;
import com.yiman.ad.log.MainLogConsole;
import com.yiman.ad.log.ToastHub;

public class MainActivity extends BaseActivity {

    private MainPanelController panelController;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TitleBar titleBar = findViewById(R.id.title_bar);
        if (titleBar != null) {
            titleBar.setTitle(R.string.app_name);
            titleBar.setListener(view -> finish());
        }

        panelController = new MainPanelController(this);
        panelController.bind();
        // 确保当前广告源单例已创建
        ensureAdLoadSingleton();

        initAdActions();
    }

    void resetAdLoad() {
        IAdLoad previous = AdbidAdLoad.getInstanceOrNull() ;
        if (previous != null) {
            previous.destroy();
        }
        ensureAdLoadSingleton();
    }

    private IAdLoad ensureAdLoadSingleton() {
        return panelController.getCurrentAdLoad();
    }

    /** 统一通过单例对象直接调用 */
    private IAdLoad adLoad() {
        return AdbidAdLoad.getInstance();
    }

    private MainLogConsole getLogConsole() {
        return panelController.getLogConsole();
    }

    @Override protected void onResume() {
        super.onResume();
        if (panelController != null) {
            panelController.rebindLogConsole();
            ensureAdLoadSingleton();
        }
    }

    private void initAdActions() {
        findViewById(R.id.btn_ad_init_load).setOnClickListener(view -> {
            getLogConsole().info("广告初始化开始...");
            adLoad().init();
        });
        findViewById(R.id.btn_app_open_load).setOnClickListener(view -> {
            getLogConsole().info("开屏广告开始加载...");
            adLoad().loadSplash();
        });
        findViewById(R.id.btn_app_open_ready).setOnClickListener(
                view -> showReadyToast("开屏广告", adLoad().isSplashReady()));
        findViewById(R.id.btn_app_open_show).setOnClickListener(view -> {
            getLogConsole().info("开屏广告开始展示...");
            adLoad().showSplash(findViewById(R.id.frame_ad));
        });
    }

    private void showReadyToast(String adName, boolean ready) {
        if (ready) {
            getLogConsole().success(adName + " isReady: true");
            ToastHub.show(this, adName + " 就绪 true");
        } else {
            getLogConsole().warning(adName + " isReady: false");
            ToastHub.show(this, adName + " 就绪 false");
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (panelController != null) {
            panelController.unbind();
        }
        IAdLoad current = AdbidAdLoad.getInstanceOrNull();
        if (current != null) {
            current.destroy();
        }
    }
}
