package com.analysys.uniapp;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.analysys.AnalysysAgent;
import com.analysys.AnalysysConfig;
import com.analysys.EncryptEnum;
import com.analysys.utils.AnalysysUtil;
import com.analysys.utils.ExceptionUtil;

import io.dcloud.feature.uniapp.UniAppHookProxy;

public class UniAnalysysPluginProxy implements UniAppHookProxy {
    @Override
    public void onSubProcessCreate(Application application) {
    }

    @Override
    public void onCreate(Application application) {
        try {
            PackageManager pm = application.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(application.getPackageName(), PackageManager.GET_META_DATA);
            int debugMode = appInfo.metaData.getInt("AnalysysPlugin:debugMode", 0);
            String appKey = appInfo.metaData.getString("AnalysysPlugin:appKey", "");
            String channel = appInfo.metaData.getString("AnalysysPlugin:channel", "");
            int encryptType = appInfo.metaData.getInt("AnalysysPlugin:encryptType", 0);
            boolean autoPageViewDuration = appInfo.metaData.getBoolean("AnalysysPlugin:autoPageViewDuration", false);
            boolean automaticCollection = appInfo.metaData.getBoolean("AnalysysPlugin:automaticCollection", true);
            boolean automaticHeatmap = appInfo.metaData.getBoolean("AnalysysPlugin:automaticHeatmap", false);
            boolean autoCollectDeviceId = appInfo.metaData.getBoolean("AnalysysPlugin:autoCollectDeviceId", false);
            String uploadUrl = appInfo.metaData.getString("AnalysysPlugin:uploadUrl", "");
            String debugUrl = appInfo.metaData.getString("AnalysysPlugin:debugUrl", "");
            String configUrl = appInfo.metaData.getString("AnalysysPlugin:configUrl", "");

            AnalysysAgent.setDebugMode(AnalysysUtil.getContext(), debugMode);
            AnalysysConfig config = new AnalysysConfig();
            config.setAppKey(appKey);
            if (!TextUtils.isEmpty(channel)) {
                config.setChannel(channel);
            }
            // 设置使用AES加密
            if (encryptType == 1) {
                config.setEncryptType(EncryptEnum.AES);
            } else if (encryptType == 2) {
                config.setEncryptType(EncryptEnum.AES_CBC);
            }
            // pageClose自动上报开关（默认关闭）
            config.setAutoPageViewDuration(autoPageViewDuration);
            // pageView自动上报总开关（默认开启）
            config.setAutoTrackPageView(automaticCollection);
            // 热图数据采集（默认关闭）
            config.setAutoHeatMap(automaticHeatmap);
            config.setAutoTrackDeviceId(autoCollectDeviceId);
            // 初始化
            AnalysysAgent.init(application, config);
            // 设置数据上传/更新地址
            if (!TextUtils.isEmpty(uploadUrl)) {
                AnalysysAgent.setUploadURL(application, uploadUrl);
            }
            // 设置 WebSocket 连接 Url
            if (!TextUtils.isEmpty(debugUrl)) {
                AnalysysAgent.setVisitorDebugURL(application, debugUrl);
            }
            // 设置配置下发 Url
            if (!TextUtils.isEmpty(configUrl)) {
                AnalysysAgent.setVisitorConfigURL(application, configUrl);
            }
        } catch (Throwable e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }
}