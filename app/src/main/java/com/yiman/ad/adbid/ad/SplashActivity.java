package com.yiman.ad.adbid.ad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yiman.ad.BaseActivity;
import com.yiman.ad.adbid.AdConfig;
import com.yiman.ad.adbid.R;
import com.yiman.ad.adbid.view.TitleBar;

import cn.vlion.ad.inland.vl48.media.VL48AdInfo;
import cn.vlion.ad.inland.vl48.media.VL48Error;
import cn.vlion.ad.inland.vl48.media.VL48Listener;
import cn.vlion.ad.inland.vl48.media.ad.VL48AppOpen;

public class SplashActivity extends BaseActivity {
    private VL48AppOpen appOpenAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_layout);
        TitleBar titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.app_spalsh_name);
        titleBar.setListener(view -> finish());
        //创建开屏广告实例
        appOpenAd = new VL48AppOpen(AdConfig.getAdConfig().getSplashUnitId());

        //设置广告监听
        appOpenAd.setAdListener(new VL48Listener() {
            @Override
            public void onAdLoad(@NonNull VL48AdInfo adInfo) {
                //获取广告价格，单位分
                double ecpm = adInfo.getPrice();
                log("开屏广告加载成功，ecpm: " + ecpm);

                // 广告加载成功，可以展示
                appOpenAd.showAd(findViewById(R.id.frame_ad));
            }

            @Override
            public void onAdLoadFail(@Nullable String s, @NonNull VL48Error vl48Error) {
                log("开屏广告加载失败");
            }

            @Override
            public void onAdDisplayed(@NonNull VL48AdInfo vl48AdInfo) {
                log("开屏广告展示");
            }

            @Override
            public void onAdDisplayedFailed(@NonNull VL48AdInfo vl48AdInfo, @NonNull VL48Error vl48Error) {
                log("开屏广告失败：" + vl48Error.getMessage());
            }

            @Override
            public void onAdHidden(@NonNull VL48AdInfo vl48AdInfo) {
                log("开屏广告关闭");
            }

            @Override
            public void onAdClicked(@NonNull VL48AdInfo vl48AdInfo) {
                log("开屏广告触发点击");
            }
        });

        // 加载广告
        appOpenAd.loadAd();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 销毁广告
        if (appOpenAd != null) {
            appOpenAd.destroy();
            appOpenAd = null;
        }

    }

    StringBuilder stringBuilder = new StringBuilder("广告日志：\n");

    private void log(String msg) {
        stringBuilder.append(msg + ";\n");
        TextView textView = findViewById(R.id.text_layout);
        textView.setText(stringBuilder.toString());
    }
}
