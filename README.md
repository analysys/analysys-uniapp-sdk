使用说明

1、将sdk插件拷贝到项目中，目录结构如下：

```
+ root_dir
	...
	+ nativeplugins
		+ AnalysysPlugin
			- android
			- ios
			- package.json
	...
```

2、在manifest.json中配置sdk参数

```
debugMode：debug类型，0：关闭Debug模式，1：打开Debug模式，但该模式下发送的数据仅用于调试，不进行数据导入，2：打开Debug模式，		并入库计算，默认 0
appKey：易观分配唯一标识
channel：App发布的渠道标识
encryptType ：1：AES ECB加密，2：AES CBC加密
setAutoPageViewDuration: 开启页面时长采集开关。true：开启，false：不开启，默认 false
automaticCollection ：设置是否允许页面自动采集。true：开启，false：不开启，默认 false
automaticHeatmap ：是否开启热图，默认值：false
setAutoTrackDeviceId: 是否允许采集设备id，默认值：false
uploadUrl ：设置上传数据地址，如：https://arkpaastest.analysys.cn:8089
debugUrl ：设置可视化websocket服务器地址，如：ws://arkpaastest.analysys.cn:9091
configUrl ：设置可视化埋点配置的服务器地址，如：https://arkpaastest.analysys.cn:8089
```

3、调用接口

```
var analysysModule = uni.requireNativePlugin("AnalysysPlugin-UniAnalysysAgentModule")
analysysModule.track("test")
```