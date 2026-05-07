package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final InmobiLibraryAccessors laccForInmobiLibraryAccessors = new InmobiLibraryAccessors(owner);
    private final MbridgeLibraryAccessors laccForMbridgeLibraryAccessors = new MbridgeLibraryAccessors(owner);
    private final PagLibraryAccessors laccForPagLibraryAccessors = new PagLibraryAccessors(owner);
    private final PlayLibraryAccessors laccForPlayLibraryAccessors = new PlayLibraryAccessors(owner);
    private final UnityLibraryAccessors laccForUnityLibraryAccessors = new UnityLibraryAccessors(owner);
    private final VungleLibraryAccessors laccForVungleLibraryAccessors = new VungleLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for glide (com.github.bumptech.glide:glide)
     * with versionRef 'glide'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGlide() {
            return create("glide");
    }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at inmobi
     */
    public InmobiLibraryAccessors getInmobi() {
        return laccForInmobiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at mbridge
     */
    public MbridgeLibraryAccessors getMbridge() {
        return laccForMbridgeLibraryAccessors;
    }

    /**
     * Returns the group of libraries at pag
     */
    public PagLibraryAccessors getPag() {
        return laccForPagLibraryAccessors;
    }

    /**
     * Returns the group of libraries at play
     */
    public PlayLibraryAccessors getPlay() {
        return laccForPlayLibraryAccessors;
    }

    /**
     * Returns the group of libraries at unity
     */
    public UnityLibraryAccessors getUnity() {
        return laccForUnityLibraryAccessors;
    }

    /**
     * Returns the group of libraries at vungle
     */
    public VungleLibraryAccessors getVungle() {
        return laccForVungleLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxRecyclerviewLibraryAccessors laccForAndroidxRecyclerviewLibraryAccessors = new AndroidxRecyclerviewLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
         * with versionRef 'appcompat'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() {
                return create("androidx.appcompat");
        }

            /**
             * Creates a dependency provider for browser (androidx.browser:browser)
         * with versionRef 'browser'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBrowser() {
                return create("androidx.browser");
        }

            /**
             * Creates a dependency provider for constraintlayout (androidx.constraintlayout:constraintlayout)
         * with versionRef 'constraintlayout'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConstraintlayout() {
                return create("androidx.constraintlayout");
        }

            /**
             * Creates a dependency provider for core (androidx.core:core)
         * with versionRef 'core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("androidx.core");
        }

            /**
             * Creates a dependency provider for viewpager (androidx.viewpager:viewpager)
         * with versionRef 'viewpager'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getViewpager() {
                return create("androidx.viewpager");
        }

        /**
         * Returns the group of libraries at androidx.recyclerview
         */
        public AndroidxRecyclerviewLibraryAccessors getRecyclerview() {
            return laccForAndroidxRecyclerviewLibraryAccessors;
        }

    }

    public static class AndroidxRecyclerviewLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxRecyclerviewLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for recyclerview (androidx.recyclerview:recyclerview)
         * with versionRef 'recyclerview'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("androidx.recyclerview");
        }

            /**
             * Creates a dependency provider for v121 (androidx.recyclerview:recyclerview)
         * with versionRef 'recyclerviewVersion'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getV121() {
                return create("androidx.recyclerview.v121");
        }

    }

    public static class InmobiLibraryAccessors extends SubDependencyFactory {
        private final InmobiAdsLibraryAccessors laccForInmobiAdsLibraryAccessors = new InmobiAdsLibraryAccessors(owner);

        public InmobiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at inmobi.ads
         */
        public InmobiAdsLibraryAccessors getAds() {
            return laccForInmobiAdsLibraryAccessors;
        }

    }

    public static class InmobiAdsLibraryAccessors extends SubDependencyFactory {

        public InmobiAdsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kotlin (com.inmobi.monetization:inmobi-ads-kotlin)
         * with versionRef 'inmobiAdsKotlin'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKotlin() {
                return create("inmobi.ads.kotlin");
        }

    }

    public static class MbridgeLibraryAccessors extends SubDependencyFactory {
        private final MbridgeAndroidLibraryAccessors laccForMbridgeAndroidLibraryAccessors = new MbridgeAndroidLibraryAccessors(owner);

        public MbridgeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at mbridge.android
         */
        public MbridgeAndroidLibraryAccessors getAndroid() {
            return laccForMbridgeAndroidLibraryAccessors;
        }

    }

    public static class MbridgeAndroidLibraryAccessors extends SubDependencyFactory {

        public MbridgeAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for sdk (com.mbridge.msdk.oversea:mbridge_android_sdk)
         * with versionRef 'mbridge.android.sdk'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSdk() {
                return create("mbridge.android.sdk");
        }

    }

    public static class PagLibraryAccessors extends SubDependencyFactory {

        public PagLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for sdk (com.pangle.global:pag-sdk)
         * with versionRef 'pagSdk'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSdk() {
                return create("pag.sdk");
        }

    }

    public static class PlayLibraryAccessors extends SubDependencyFactory {
        private final PlayServicesLibraryAccessors laccForPlayServicesLibraryAccessors = new PlayServicesLibraryAccessors(owner);

        public PlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at play.services
         */
        public PlayServicesLibraryAccessors getServices() {
            return laccForPlayServicesLibraryAccessors;
        }

    }

    public static class PlayServicesLibraryAccessors extends SubDependencyFactory {
        private final PlayServicesAdsLibraryAccessors laccForPlayServicesAdsLibraryAccessors = new PlayServicesAdsLibraryAccessors(owner);

        public PlayServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appset (com.google.android.gms:play-services-appset)
         * with versionRef 'playServicesAppset'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppset() {
                return create("play.services.appset");
        }

            /**
             * Creates a dependency provider for location (com.google.android.gms:play-services-location)
         * with versionRef 'playServicesLocation'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLocation() {
                return create("play.services.location");
        }

            /**
             * Creates a dependency provider for tasks (com.google.android.gms:play-services-tasks)
         * with versionRef 'playServicesTasks'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTasks() {
                return create("play.services.tasks");
        }

        /**
         * Returns the group of libraries at play.services.ads
         */
        public PlayServicesAdsLibraryAccessors getAds() {
            return laccForPlayServicesAdsLibraryAccessors;
        }

    }

    public static class PlayServicesAdsLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public PlayServicesAdsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ads (com.google.android.gms:play-services-ads)
         * with versionRef 'playServicesAds'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("play.services.ads");
        }

            /**
             * Creates a dependency provider for identifier (com.google.android.gms:play-services-ads-identifier)
         * with versionRef 'playServicesAdsIdentifier'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getIdentifier() {
                return create("play.services.ads.identifier");
        }

    }

    public static class UnityLibraryAccessors extends SubDependencyFactory {

        public UnityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ads (com.unity3d.ads:unity-ads)
         * with versionRef 'unityAds'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAds() {
                return create("unity.ads");
        }

    }

    public static class VungleLibraryAccessors extends SubDependencyFactory {

        public VungleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ads (com.vungle:vungle-ads)
         * with versionRef 'vungleAds'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAds() {
                return create("vungle.ads");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final MbridgeVersionAccessors vaccForMbridgeVersionAccessors = new MbridgeVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: appcompat (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompat() { return getVersion("appcompat"); }

            /**
             * Returns the version associated to this alias: browser (1.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBrowser() { return getVersion("browser"); }

            /**
             * Returns the version associated to this alias: constraintlayout (2.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConstraintlayout() { return getVersion("constraintlayout"); }

            /**
             * Returns the version associated to this alias: core (1.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("core"); }

            /**
             * Returns the version associated to this alias: glide (4.16.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGlide() { return getVersion("glide"); }

            /**
             * Returns the version associated to this alias: inmobiAdsKotlin (10.8.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getInmobiAdsKotlin() { return getVersion("inmobiAdsKotlin"); }

            /**
             * Returns the version associated to this alias: pagSdk (7.2.0.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPagSdk() { return getVersion("pagSdk"); }

            /**
             * Returns the version associated to this alias: playServicesAds (24.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlayServicesAds() { return getVersion("playServicesAds"); }

            /**
             * Returns the version associated to this alias: playServicesAdsIdentifier (18.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlayServicesAdsIdentifier() { return getVersion("playServicesAdsIdentifier"); }

            /**
             * Returns the version associated to this alias: playServicesAppset (16.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlayServicesAppset() { return getVersion("playServicesAppset"); }

            /**
             * Returns the version associated to this alias: playServicesLocation (21.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlayServicesLocation() { return getVersion("playServicesLocation"); }

            /**
             * Returns the version associated to this alias: playServicesTasks (18.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlayServicesTasks() { return getVersion("playServicesTasks"); }

            /**
             * Returns the version associated to this alias: recyclerview (1.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRecyclerview() { return getVersion("recyclerview"); }

            /**
             * Returns the version associated to this alias: recyclerviewVersion (1.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRecyclerviewVersion() { return getVersion("recyclerviewVersion"); }

            /**
             * Returns the version associated to this alias: unityAds (4.16.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUnityAds() { return getVersion("unityAds"); }

            /**
             * Returns the version associated to this alias: viewpager (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getViewpager() { return getVersion("viewpager"); }

            /**
             * Returns the version associated to this alias: vungleAds (7.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVungleAds() { return getVersion("vungleAds"); }

        /**
         * Returns the group of versions at versions.mbridge
         */
        public MbridgeVersionAccessors getMbridge() {
            return vaccForMbridgeVersionAccessors;
        }

    }

    public static class MbridgeVersionAccessors extends VersionFactory  {

        private final MbridgeAndroidVersionAccessors vaccForMbridgeAndroidVersionAccessors = new MbridgeAndroidVersionAccessors(providers, config);
        public MbridgeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.mbridge.android
         */
        public MbridgeAndroidVersionAccessors getAndroid() {
            return vaccForMbridgeAndroidVersionAccessors;
        }

    }

    public static class MbridgeAndroidVersionAccessors extends VersionFactory  {

        public MbridgeAndroidVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: mbridge.android.sdk (16.9.91)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSdk() { return getVersion("mbridge.android.sdk"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
