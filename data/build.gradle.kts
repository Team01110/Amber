@file:Suppress("DEPRECATION")

plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.data"
    compileSdk = AppConfig.targetSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        buildConfigField ("String", "BASE_URL", "\"https://amberjewelery.pythonanywhere.com/\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val consumerProguardFiles = "consumer-rules.pro"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation("com.google.firebase:firebase-auth-ktx:21.3.0")
    testImplementation(Dependencies.UI.junit)
    androidTestImplementation(Dependencies.UI.test_junit)
    androidTestImplementation(Dependencies.UI.espresso)
    api(project(":domain"))

    //Room
    implementation(Dependencies.Room.room_runtime)
    implementation(Dependencies.Room.room_ktx)
    kapt(Dependencies.Room.room_compiler)

    //Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converter)

    //Coroutine
    implementation(Dependencies.Coroutine.coroutines)
    implementation(Dependencies.Coroutine.coroutinescore)

    //Hilt
    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.hilt_compiler)
}