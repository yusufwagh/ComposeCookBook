import com.guru.composecookbook.build.configurations.ProjectConfigs
import com.guru.composecookbook.build.dependencies.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectConfigs.compileSdkVersion

    defaultConfig {
        applicationId = ProjectConfigs.applicationId
        minSdk = ProjectConfigs.minSdkVersion
        targetSdk = ProjectConfigs.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"

    }
    kapt {
        correctErrorTypes = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ProjectConfigs.kotlinCompilerExtensionVersion
    }
    lint {
        isAbortOnError = false
    }
    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":theme"))
    implementation(project(":demos:instagram"))
    implementation(project(":demos:cryptoapp"))
    implementation(project(":components:charts"))

    addKotlinDependencies()

    addDataDependencies()

    addComposeOfficialDependencies()
    addComposeDebugDependencies()
    addComposeThirdPartyDependencies()

    addThirdPartyUiDependencies()

    addCoreAndroidDependencies()
    addCoreAndroidUiDependencies()
    addGoogleAndroidDependencies()
    addNetworkingDependencies()

    addKotlinTestDependencies()
    addJunit5TestDependencies()
    addThirdPartyUnitTestsDependencies()

    addAndroidInstrumentationTestsDependencies()

}