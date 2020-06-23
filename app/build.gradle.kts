plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinAndroidExtensions)
    kotlin(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = "com.example.movieslisttask"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures{
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(Libraries.kotlinStdLib)

    // Support Libraries
    implementation(Libraries.appCompat)
    implementation(Libraries.recyclerView)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)
    implementation(Libraries.cardView)
    implementation(Libraries.lifecycleViewModelKtx)
    implementation(Libraries.lifecycleExtensions)

    // GLIDE
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    // ROOM
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)

    // RETROFIT
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGson)
    implementation(Libraries.okHttpInterceptor)

    //COIN
    implementation(Libraries.koin_core)
    implementation(Libraries.koin_viewmodel)
}
