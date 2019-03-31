package dependencies

@Suppress("unused")
object Depends {

    /* ========================================
     * Gradle
     * ========================================*/

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:3.5.0-alpha09"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
        const val playServices = "com.google.gms:google-services:4.2.0"
        // To report crash log
        const val fabric = "io.fabric.tools:gradle:1.+"
        // To generate OSS license page
        const val ossLicenses = "com.google.android.gms:oss-licenses-plugin:0.9.4"
        // To upload apk to GooglePlayStore
        const val playPublisher = "com.github.triplet.gradle:play-publisher:1.2.0"
        // To check the library update
        const val gradleVersions = "com.github.ben-manes:gradle-versions-plugin:0.21.0"
        // To remove unused resources
        const val unusedResources = "gradle.plugin.com.github.konifar.gradle:plugin:0.3.3"
    }


    /* ========================================
     * Test
     * ========================================*/

    object Test {
        const val junit = "junit:junit:4.13-beta-2"
        const val testRunner = "androidx.test:runner:1.1.2-alpha02"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
        const val mockitoInline = "org.mockito:mockito-inline:2.23.4"
    }


    /* ========================================
     * Google
     * ========================================*/

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0-alpha03"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.0.0"
        const val cardView = "androidx.cardview:cardview:1.0.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-alpha3"
        const val coreKtx = "androidx.core:core-ktx:1.0.0-alpha1"
        const val annotation = "androidx.annotation:annotation:1.0.0-alpha1"
        const val browser = "androidx.browser:browser:1.0.0"

        object DataBinding {
            private const val version = "3.5.0"
            const val common = "androidx.databinding:databinding-common:$version"
            const val runtime = "androidx.databinding:databinding-runtime:$version"
        }

        object Lifecycle {
            private const val version = "2.0.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata:$version"
        }
    }

    object Material {
        const val core = "com.google.android.material:material:1.1.0-alpha05"
    }

    object Gms {
        // To generate OSS license page
        const val ossLicenses = "com.google.android.gms:play-services-oss-licenses:16.0.2"
    }


    /* ========================================
     * Structure
     * ========================================*/

    object Kotlin {
        const val version = "1.3.21"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
    }


    /* ========================================
     * Debug
     * ========================================*/

    object Fabric {
        // To report crash log
        const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.9.9@aar"
    }

    object Timber {
        // Logger utility
        const val core = "com.jakewharton.timber:timber:4.7.1"
    }


    /* ========================================
     * UI
     * ========================================*/

    object Ui {
        const val roundedimageview = "com.makeramen:roundedimageview:2.3.0"
    }
}