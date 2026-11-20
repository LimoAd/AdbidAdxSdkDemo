# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Glide 4.x
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelableInputStream

-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

# 领摩 ADX SDK 通过反射调用 Glide（com.adbid.adx.ad.n0），类名与方法名都不能被混淆
-keep public class com.bumptech.glide.Glide {
    public static *** with(...);
}
-keep public class com.bumptech.glide.RequestManager {
    public *** asBitmap();
}
-keep public class com.bumptech.glide.RequestBuilder {
    public *** load(...);
    public *** listener(...);
    public *** into(android.widget.ImageView);
}
-keep public interface com.bumptech.glide.request.RequestListener { *; }

