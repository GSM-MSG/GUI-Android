plugins {
    id (BuildPlugins.ANDROID_APPLICATION_PLUGIN)
    id (BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id (BuildPlugins.KOTLIN_KAPT)
}

android {
    namespace = ProjectProperties.APPLICATION_ID
    compileSdk = ProjectProperties.TARGET_SDK

    defaultConfig {
        applicationId = ProjectProperties.APPLICATION_ID
        minSdk = ProjectProperties.MIN_SDK
        targetSdk = ProjectProperties.TARGET_SDK
        versionCode = ProjectProperties.VERSION_CODE
        versionName = ProjectProperties.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary =  true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.JAVA_VERSION
        targetCompatibility = ProjectProperties.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependency.Core.CORE)
    implementation (Dependency.LifeCycle.LIFECYCLE_RUNTIME)
    implementation (Dependency.Compose.COMPOSE_ACTIVITY)
    implementation (Dependency.Compose.COMPOSE_UI)
    implementation (Dependency.Compose.COMPOSE_PREVIEW)
    implementation (Dependency.Compose.COMPOSE_MATERIAL)
    androidTestImplementation (Dependency.AndroidTest.ESPRESSO_CORE)
    androidTestImplementation (Dependency.Compose.COMPOSE_JUNIT)
    debugImplementation (Dependency.Compose.COMPOSE_TOOLING)
    debugImplementation (Dependency.Compose.COMPOSE_MANIFEST)

    implementation(Dependency.Moshi.MOSHI)
    kapt(Dependency.Moshi.MOSHI_COMPILER)

    testImplementation(Dependency.UnitTest.JUNIT)
    testImplementation(Dependency.UnitTest.MOCKITO)
    testImplementation(Dependency.UnitTest.MOCKITO_KOTLIN)
    testImplementation(Dependency.UnitTest.MOCKITO_INLINE)

    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.RETROFIT_CONVERTER_GSON)

    implementation(Dependency.OkHttp.OKHTTP)
    implementation(Dependency.OkHttp.OKHTTP_LOGGING_INTERCEPTOR)

}