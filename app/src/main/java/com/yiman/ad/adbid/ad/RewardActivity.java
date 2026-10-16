package com.yiman.ad.adbid.ad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cqyh.cqadsdk.yz.media.CQYzAdInfo;
import com.cqyh.cqadsdk.yz.media.CQYzError;
import com.cqyh.cqadsdk.yz.media.CQYzRewardListener;
import com.cqyh.cqadsdk.yz.media.ad.CQYzRewarded;
import com.yiman.ad.adbid.AdConfig;
import com.yiman.ad.BaseActivity;
import com.yiman.ad.adbid.R;
import com.yiman.ad.adbid.view.TitleBar;

public class RewardActivity extends BaseActivity {
    @Nullable CQYzRewarded rewardedAd;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_layout);
        TitleBar titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.app_reward_name);
        titleBar.setListener(view -> finish());

        //创建激励广告
        rewardedAd = new CQYzRewarded(AdConfig.getAdConfig().getRewardUnitId());
        rewardedAd.setAdListener(new CQYzRewardListener() {
            @Override public void onUserReward(@NonNull CQYzAdInfo adInfo) {
                log( "激励视频领取奖励");
            }

            @Override public void onAdLoad(@NonNull CQYzAdInfo adInfo) {
                //获取广告价格，单位分
                double price = adInfo.getPrice();
                log( "激励视频广告加载完成, ecpm: "+price);

                //展示广告
                if (rewardedAd != null)
                    rewardedAd.showAd();
            }

            @Override
            public void onAdLoadFail(@Nullable String adUnitId, @NonNull CQYzError error) {
                log( "激励视频广告加载失败：" + error.getMessage());
            }

            @Override public void onAdDisplayed(@NonNull CQYzAdInfo adInfo) {
                log( "激励视频广告展示成功");
            }

            @Override
            public void onAdDisplayedFailed(@Nullable CQYzAdInfo adInfo,@NonNull CQYzError error) {
                log( "激励视频广告展示失败: " + error.getMessage());
            }

            @Override public void onAdHidden(@NonNull CQYzAdInfo adInfo) {
                log( "激励视频广告关闭");
            }

            @Override public void onAdClicked(@NonNull CQYzAdInfo adInfo) {
                log( "激励视频广告触发点击");
            }
        });

        //加载广告
        rewardedAd.loadAd();
    }

    @Override protected void onDestroy() {
        super.onDestroy();

        //销毁广告
        if (rewardedAd != null) {
            rewardedAd.destroy();
            rewardedAd = null;
        }
    }

    StringBuilder stringBuilder = new StringBuilder("广告日志：\n");

    private void log(String msg) {
        stringBuilder.append(msg + ";\n");
        TextView textView = findViewById(R.id.text_layout);
        textView.setText(stringBuilder.toString());
    }
}
