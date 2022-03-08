package com.analysys.uniapp;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.analysys.AnalysysAgent;
import com.analysys.process.AgentProcess;
import com.analysys.utils.AnalysysUtil;
import com.analysys.utils.Constants;
import com.analysys.utils.ExceptionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.common.UniDestroyableModule;

public class UniAnalysysAgentModule extends UniDestroyableModule {

    @UniJSMethod()
    public void setDebugMode(int debugMode) {
        AnalysysAgent.setDebugMode(AnalysysUtil.getContext(), debugMode);
    }

    @UniJSMethod()
    public void setUploadURL(String url) {
        AnalysysAgent.setUploadURL(AnalysysUtil.getContext(), url);
    }

    @UniJSMethod()
    public void setAutomaticCollection(boolean isAuto) {
        AnalysysAgent.setAutomaticCollection(AnalysysUtil.getContext(), isAuto);
    }

    @UniJSMethod()
    public void setIntervalTime(long flushInterval) {
        AnalysysAgent.setIntervalTime(AnalysysUtil.getContext(), flushInterval);
    }

    @UniJSMethod()
    public void setMaxEventSize(long eventSize) {
        AnalysysAgent.setMaxEventSize(AnalysysUtil.getContext(), eventSize);
    }

    @UniJSMethod()
    public void setMaxCacheSize(long cacheSize) {
        AnalysysAgent.setMaxCacheSize(AnalysysUtil.getContext(), cacheSize);
    }

    @UniJSMethod()
    public void launchSource(int source) {
        AnalysysAgent.launchSource(source);
    }

    @UniJSMethod()
    public void setPageViewBlackListByPages(List arrayList) {
        List<String> listArr = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            listArr.add((String) arrayList.get(i));
        }
        AnalysysAgent.setPageViewBlackListByPages(listArr);
    }

    @UniJSMethod()
    public void flush() {
        AnalysysAgent.flush(AnalysysUtil.getContext());
    }

    @UniJSMethod()
    public void cleanDBCache() {
        AnalysysAgent.cleanDBCache();
    }

    @UniJSMethod()
    public void setPush(String provider, String pushId) {
        AnalysysAgent.setPushID(AnalysysUtil.getContext(), provider, pushId);
    }

    @UniJSMethod()
    public void pageViewWithArgsAuto(String pageName, JSONObject properties) {
        try {
            if (AgentProcess.getInstance().getConfig().isAutoTrackPageView()) {
                pageViewWithArgs(pageName, properties);
            }
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void pageViewWithArgs(String pageName, JSONObject properties) {
        try {
            if (properties == null) {
                AnalysysUtil.setRNUrl(pageName);
                AnalysysAgent.pageView(AnalysysUtil.getContext(), pageName);
            } else {
                Map<String, Object> hashMap = convertToMap(properties);
                String url = (String) hashMap.get(Constants.PAGE_URL);
                if (!TextUtils.isEmpty(url)) {
                    AnalysysUtil.setRNUrl(url);
                } else {
                    AnalysysUtil.setRNUrl(pageName);
                }
                AnalysysAgent.pageView(AnalysysUtil.getContext(), pageName, hashMap);
            }
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void pageView(String pageName) {
        try {
            AnalysysUtil.setRNUrl(pageName);
            AnalysysAgent.pageView(AnalysysUtil.getContext(), pageName);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void track(String eventName) {
        try {
            AnalysysAgent.track(AnalysysUtil.getContext(), eventName);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void trackWithArgs(String eventName, JSONObject properties) {
        try {
            if (properties == null) {
                AnalysysAgent.track(AnalysysUtil.getContext(), eventName);
            } else {
                Map<String, Object> hashMap = convertToMap(properties);
                AnalysysAgent.track(AnalysysUtil.getContext(), eventName, hashMap);
            }
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void identify(String distinctId) {
        try {
            AnalysysAgent.identify(AnalysysUtil.getContext(), distinctId);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void alias(String aliasId) {
        try {
            AnalysysAgent.alias(AnalysysUtil.getContext(), aliasId);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod(uiThread = false)
    public String getDistinctId() {
        try {
            return AnalysysAgent.getDistinctId(AnalysysUtil.getContext());
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
        return null;
    }

    @UniJSMethod()
    public void profileSet(JSONObject properties) {
        try {
            Map<String, Object> hashMap = convertToMap(properties);
            AnalysysAgent.profileSet(AnalysysUtil.getContext(), hashMap);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void profileSetOnce(JSONObject properties) {
        try {
            Map<String, Object> hashMap = convertToMap(properties);
            AnalysysAgent.profileSetOnce(AnalysysUtil.getContext(), hashMap);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void profileIncrement(JSONObject properties) {
        try {
            Map<String, Number> hashMap = convertToNumberMap(properties);
            AnalysysAgent.profileIncrement(AnalysysUtil.getContext(), hashMap);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }


    @UniJSMethod()
    public void profileAppend(JSONObject properties) {
        try {
            Map<String, Object> hashMap = convertToMap(properties);
            AnalysysAgent.profileAppend(AnalysysUtil.getContext(), hashMap);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void profileUnset(String profileKey) {
        try {
            AnalysysAgent.profileUnset(AnalysysUtil.getContext(), profileKey);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void profileDelete() {
        try {
            AnalysysAgent.profileDelete(AnalysysUtil.getContext());
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void registerSuperProperty(String superPropertyName, String superPropertyValue) {
        try {
            AnalysysAgent.registerSuperProperty(AnalysysUtil.getContext(), superPropertyName, superPropertyValue);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void registerSuperProperties(JSONObject properties) {
        try {
            Map<String, Object> hashMap = convertToMap(properties);
            AnalysysAgent.registerSuperProperties(AnalysysUtil.getContext(), hashMap);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void unRegisterSuperProperty(String superPropertyName) {
        try {
            AnalysysAgent.unRegisterSuperProperty(AnalysysUtil.getContext(), superPropertyName);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void clearSuperProperties() {
        try {
            AnalysysAgent.clearSuperProperties(AnalysysUtil.getContext());
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod(uiThread = false)
    public String getSuperProperty(String superPropertyName) {
        try {
            return AnalysysAgent.getSuperProperty(AnalysysUtil.getContext(), superPropertyName).toString();
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
        return null;
    }

    @UniJSMethod(uiThread = false)
    public JSONObject getSuperProperties() {
        try {
            return new JSONObject(AnalysysAgent.getSuperProperties(AnalysysUtil.getContext()));
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
        return null;
    }

    @UniJSMethod(uiThread = false)
    public JSONObject getPresetProperties() {
        try {
            return new JSONObject(AnalysysAgent.getPresetProperties(AnalysysUtil.getContext()));
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
        return null;
    }

    @UniJSMethod()
    public void reset() {
        try {
            AnalysysAgent.reset(AnalysysUtil.getContext());
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @UniJSMethod()
    public void setUploadNetworkType(int networkType) {
        try {
            AnalysysAgent.setUploadNetworkType(networkType);
        } catch (Exception e) {
            ExceptionUtil.exceptionPrint(e);
        }
    }

    @Override
    public void destroy() {

    }

    private Map<String, Object> convertToMap(JSONObject obj) {
        Map<String, Object> res = new HashMap<>();
        if (obj != null && obj.size() > 0) {
            Iterator<String> it = obj.keySet().iterator();
            while (it.hasNext()) {
                final String key = it.next();
                final Object o = obj.get(key);
                res.put(key, o);
            }
        }
        return res;
    }

    private Map<String, Number> convertToNumberMap(JSONObject obj) {
        Map<String, Number> res = new HashMap<>();
        if (obj != null && obj.size() > 0) {
            Iterator<String> it = obj.keySet().iterator();
            while (it.hasNext()) {
                final String key = it.next();
                final Number o = (Number) obj.get(key);
                res.put(key, o);
            }
        }
        return res;
    }
}
