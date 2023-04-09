import org.jetbrains.kotlin.gradle.targets.js.npm.includedRange

plugins {
    id (Plugins.AGP.library)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
}


android {
    namespace = "com.example.data"
    compileSdk  = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation (Dependencies.UI.core)
    implementation (Dependencies.UI.appcompat)
    implementation (Dependencies.UI.material)
    testImplementation (Dependencies.UI.junit)
    androidTestImplementation (Dependencies.UI.test_junit)
    androidTestImplementation (Dependencies.UI.espresso)
    implementation(project(":domain"))


    //Room
    implementation (Dependencies.Room.room_runtime)
    implementation (Dependencies.Room.room_ktx)
    kapt (Dependencies.Room.room_compiler)

    //Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converter)

    //Coroutine
    implementation (Dependencies.Coroutine.coroutines)
    implementation(Dependencies.Coroutine.coroutinescore)

    //Hilt
    implementation (Dependencies.DaggerHilt.hilt)
    kapt (Dependencies.DaggerHilt.hilt_compiler)

    implementation(Plugins.Retrofit.retrofit)
    implementation(Plugins.Retrofit.converter)

    //Coroutine
    implementation (Dependencies.Coroutine.coroutines)
    implementation(Dependencies.Coroutine.coroutinescore)

}