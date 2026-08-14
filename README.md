## 领摩Sdk接入文档

### 功能特性
- 多广告形式支持：提供开屏、横幅、插屏、激励视频、原生信息流等多种广告形式
- 标准化接入：提供统一的API接口，简化集成流程
- 高性能渲染：优化广告加载速度，保障用户体验
- 隐私：SDK不会向用户主动申请隐私权限。
- 聚合：SDK支持海内外主流广告平台同步请求与竞价，需联系商务开启
- 体积：SDK体积小，约1.3M左右

### 环境要求
|组件|最低要求|推荐配置|
|---|---|---|
|Android版本|API 21 (Android 5.0)|API 28 (Android 9.0)+|
|编译工具|Android Studio|Android Studio Giraffe+|
|Gradle版本|7.5|7.4+|

### 支持平台
领摩adx

### SDK版本
- 版本号：`2.1.0.21`
- AAR：`app/libs/adbid_sdk_2.1.0.21_0814_1532.aar`

### 接入文档
- 本地详细文档（初始化 / 开屏 / 竞胜竞败）：[`Android Adx Sdk接入文档.docx`](./Android%20Adx%20Sdk接入文档.docx)
- 在线文档：https://docs.qq.com/aio/p/sclx3ejo3guwfau?p=6FFbVrgFs1FZL6IHiSraJP

### 主要 API（2.1.0.21）
|能力|类|
|---|---|
|SDK入口|`VL48Sdk`|
|初始化配置|`VL48InitConfig` / `VL48CustomController`|
|开屏广告|`VL48AppOpen`|
|广告回调|`VL48Listener` / `VL48AdInfo` / `VL48Error`|
|广告素材|`VL48AdInfo.getAdMaterialInfo()` → `VL48MaterialInfo`|
|竞胜竞败|`winNotice` / `lossNotice(VL48LossInfo)`|

Demo 参考：
- 初始化：`app/src/main/java/com/yiman/ad/adbid/AdbidAdLoad.java`
- 开屏：`app/src/main/java/com/yiman/ad/adbid/ad/SplashActivity.java`
