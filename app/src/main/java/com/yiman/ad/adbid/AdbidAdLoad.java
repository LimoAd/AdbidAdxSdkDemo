package com.yiman.ad.adbid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yiman.ad.utils.StringUtils;
import cn.vlion.ad.inland.vl48.media.VL48AdbidAdInfo;
import cn.vlion.ad.inland.vl48.media.VL48AdbidError;
import cn.vlion.ad.inland.vl48.media.VL48AdbidListener;
import cn.vlion.ad.inland.vl48.media.ad.VL48AdbidAppOpen;
import cn.vlion.ad.inland.vl48.sdk.AdbidCustomController;
import cn.vlion.ad.inland.vl48.sdk.AdbidInitConfig;
import cn.vlion.ad.inland.vl48.sdk.AdbidLocation;
import cn.vlion.ad.inland.vl48.sdk.AdbidSdk;
import cn.vlion.ad.inland.vl48.sdk.AdbidSdkInitListener;
import com.yiman.ad.AppIdStore;
import com.yiman.ad.DemoRequestUtils;
import com.yiman.ad.IAdLoad;
import com.yiman.ad.MyApplication;
import com.yiman.ad.log.MainLogConsole;
import com.yiman.ad.log.ToastHub;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.List;

public class AdbidAdLoad extends IAdLoad {
    private static volatile AdbidAdLoad sInstance;

    @Nullable
    VL48AdbidAppOpen appOpenAd;
    private SoftReference<ViewGroup> adContainer;
    private String token;

    private AdbidAdLoad(Context context, MainLogConsole logConsole) {
        super(context, logConsole);
    }

    @NonNull
    public static AdbidAdLoad getInstance() {
        AdbidAdLoad instance = sInstance;
        if (instance == null) {
            throw new IllegalStateException("AdbidAdLoad not initialized, call getInstance(context, logConsole) first");
        }
        return instance;
    }

    @Nullable
    public static AdbidAdLoad getInstanceOrNull() {
        return sInstance;
    }

    @NonNull
    public static AdbidAdLoad getInstance(@NonNull Context context,
                                          @NonNull MainLogConsole logConsole) {
        if (sInstance == null) {
            synchronized (AdbidAdLoad.class) {
                if (sInstance == null) {
                    sInstance = new AdbidAdLoad(context, logConsole);
                }
            }
        } else {
            sInstance.update(context, logConsole);
        }
        return sInstance;
    }

    @Override
    public void init() {
        // Reserved for manual initialization logic.
        AdbidSdk.getInstance(MyApplication.myApplication).setDebugMode(true);
        //广告sdk初始化
        AdbidInitConfig config = AdbidInitConfig.builder(AppIdStore.getSelectedAppId())
                //设置App渠道
                .setAppChannel("xiaomi")
                //设置App版本
                .setAppVersion("1.0.0")
                //设置用户ID
                .setUserId("xxxxxx")
                //设置隐私权限
                .addCustomController(new AdbidCustomController() {
                    //是否允许SDK主动使用手机硬件参数（如IMEI）
                    @Override
                    public boolean isCanUsePhoneState() {
                        return true;
                    }

                    //是否允许SDK使用个性化广告（GDPR/CCPA合规需关闭）
                    @Override
                    public boolean isSupportPersonalized() {
                        return false;
                    }

                    //是否允许SDK主动使用地理位置信息
                    @Override
                    public boolean isCanUseLocation() {
                        return true;
                    }

                    //是否允许SDK主动获取OAID
                    @Override
                    public boolean isCanUseWifiState() {
                        return true;
                    }

                    //是否允许SDK主动获取OAID
                    @Override
                    public boolean isCanUseOaid() {
                        return true;
                    }

                    //开发者可传入OAID（当isCanUseOaid=false时生效）
                    @Nullable
                    @Override
                    public String getDevOaid() {
                        return "f5cd4f70c1319b5a";
                    }

                    //是否允许SDK获取应用安装列表
                    @Override
                    public boolean isCanUseAppList() {
                        return true;
                    }

                    //开发者可传入应用安装列表（当isCanUseAppList=false时生效）
                    @Nullable
                    @Override
                    public List<PackageInfo> getAppList() {
                        return Collections.emptyList();
                    }

                    //是否允许SDK获取ANDROID_ID
                    @Override
                    public boolean isCanUseAndroidId() {
                        return true;
                    }

                    // 开发者可传入ANDROID_ID（当isCanUseAndroidId=false时生效）
                    @Nullable
                    @Override
                    public String getAndroidId() {
                        return "";
                    }

                    //是否允许SDK获取MAC地址
                    @Override
                    public boolean isCanUseMacAddress() {
                        return true;
                    }

                    //开发者可传入MAC地址（当isCanUseMacAddress=false时生效）
                    @Nullable
                    @Override
                    public String getMacAddress() {
                        return "";
                    }

                    //是否允许写入存储卡权限
                    @Override
                    public boolean isCanUseWriteExternal() {
                        return true;
                    }

                    // 是否允许加载摇一摇广告（需加速度传感器权限）
                    @Override
                    public boolean isCanUseShakeAd() {
                        return true;
                    }

                    //是否允许SDK使用录音权限
                    @Override
                    public boolean isCanUseRecordAudio() {
                        return true;
                    }

                    //开发者可传入IMEI（当isCanUsePhoneState=false时生效）
                    @Nullable
                    @Override
                    public String getDevImei() {
                        return "";
                    }

                    //开发者可传入IMEI列表（多卡设备）
                    @Nullable
                    @Override
                    public String[] getDevImeiList() {
                        return new String[0];
                    }

                    //开发者可传入定位信息
                    @Nullable
                    @Override
                    public AdbidLocation getLocation() {
                        return null;
                    }

                    //是否允许SDK主动获取IP地址
                    @Override
                    public boolean isCanUseIP() {
                        return true;
                    }

                    //开发者可传入IP地址（当isCanUseIP=false时生效）
                    @Nullable
                    @Override
                    public String getIP() {
                        return "";
                    }
                }).build();
        AdbidSdk.getInstance(MyApplication.myApplication).initialize(config, new AdbidSdkInitListener() {
            @Override
            public void onSdkInitCallback(boolean isSuccess, VL48AdbidError adbidError) {
                if (isSuccess) {
                    logSuccess("初始化成功");
                    toast("初始化成功");
                } else {
                    logError("初始化失败");
                    toast("初始化失败");
                }

            }
        });
    }

    public void checkS2SBiddingToken(String adUnitId, Runnable callback) {
        if (!AdConfig.isS2SBiddingEnabled()) {
            callback.run();
            return;
        }
        DemoRequestUtils.requestBiddingToken(adUnitId, new DemoRequestUtils.RequestCallBack() {
            @Override
            public void onSuccess(String result) {
                if (!StringUtils.isEmpty(result)) {
                    token = result;
                }
                callback.run();
            }

            @Override
            public void onFailure() {
                token = null;
                callback.run();
            }
        });
    }

    @Override
    public void loadSplash() {
        checkS2SBiddingToken(AdConfig.getAdConfig().getSplashUnitId(), new Runnable() {
            @Override
            public void run() {
                VL48AdbidListener appOpenAdListener = new VL48AdbidListener() {
                    @Override
                    public void onAdLoad(@NonNull VL48AdbidAdInfo adInfo) {
                        logSuccess("开屏广告加载成功，eCPM " + adInfo.getPrice());
                        toast("开屏广告加载成功");
                    }

                    @Override
                    public void onAdLoadFail(@Nullable String adUnitId, @NonNull VL48AdbidError error) {
                        logError("开屏广告加载失败: " + error.getMessage());
                        toast("开屏广告加载失败");
                    }

                    @Override
                    public void onAdDisplayed(@NonNull VL48AdbidAdInfo adInfo) {
                        logSuccess("开屏广告展示成功");
                        toast("开屏广告展示成功");
                    }

                    @Override
                    public void onAdDisplayedFailed(@NonNull VL48AdbidAdInfo adInfo,
                                                    @NonNull VL48AdbidError error) {
                        logError("开屏广告展示失败: " + error.getMessage());
                        toast("开屏广告展示失败");
                    }

                    @Override
                    public void onAdHidden(@NonNull VL48AdbidAdInfo adInfo) {
                        ViewGroup container = adContainer == null ? null : adContainer.get();
                        if (container != null) container.removeAllViews();
                        logInfo("开屏广告关闭");
                        toast("开屏广告关闭");
                    }

                    @Override
                    public void onAdClicked(@NonNull VL48AdbidAdInfo adInfo) {
                        logInfo("开屏广告被点击");
                        toast("开屏广告被点击");
                    }
                };
                if (appOpenAd != null) {
                    appOpenAd.destroy();
                }
                if (StringUtils.isEmpty(token)) {
                    appOpenAd = new VL48AdbidAppOpen(AdConfig.getAdConfig().getSplashUnitId());
                } else {
                    appOpenAd = new VL48AdbidAppOpen(AdConfig.getAdConfig().getSplashUnitId(), token);
                }
                appOpenAd.setAdListener(appOpenAdListener);
                appOpenAd.loadAd();
            }
        });
    }


    @Override
    public boolean isSplashReady() {
        return appOpenAd != null && appOpenAd.isReady();
    }

    @Override
    public void showSplash(@NonNull ViewGroup viewGroup) {
        adContainer = new SoftReference<>(viewGroup);
        if (isSplashReady()) {
            appOpenAd.showAd(viewGroup);
        }
    }

    @Override
    public void destroy() {
        if (appOpenAd != null) {
            appOpenAd.destroy();
            appOpenAd = null;
        }
    }

    private void logInfo(String msg) {
        logConsole.info(msg);
        Log.i("AdbidSdk", msg);
    }

    private void logSuccess(String msg) {
        logConsole.success(msg);
        Log.i("AdbidSdk", msg);
    }

    private void logError(String msg) {
        logConsole.error(msg);
        Log.e("AdbidSdk", msg);
    }

    private void toast(String msg) {
        ToastHub.show(context, msg);
    }
}
