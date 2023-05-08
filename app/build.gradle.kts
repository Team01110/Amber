@file:Suppress("DEPRECATION")

plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
    id(Plugins.AGP.google_service)
}

android {
    namespace = "com.example.amber"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.amber"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

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

    packagingOptions {
        resources.excludes.add("META-INF/versions/9/previous-compilation-data.bin")
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraintlayout)
    implementation(Dependencies.UI.viewmodel)
    implementation(Dependencies.UI.fragment)
    implementation(Dependencies.UI.stdlib)
    implementation(Dependencies.Firebase.firebase_auth)
    implementation(project(mapOf("path" to ":domain")))
    testImplementation(Dependencies.UI.junit)
    androidTestImplementation(Dependencies.UI.test_junit)
    androidTestImplementation(Dependencies.UI.espresso)
    implementation(project(":domain"))
    implementation(project(":data"))

    //google
    implementation(Dependencies.Google.google_service_auth)

    //Hilt
    implementation(Dependencies.DaggerHilt.hilt)
    kapt (Dependencies.DaggerHilt.hilt_compiler)

    //Coroutine
    implementation(Dependencies.Coroutine.coroutines)

    //ViewPager2
    implementation(Dependencies.viewpager2.viewpager2)

    //Navigation
    implementation(Dependencies.Nav.navigation_fragment)
    implementation(Dependencies.Nav.navigation)

    //Firebase
     implementation (Dependencies.Firebase.firebase_auth)
     implementation (Dependencies.Firebase.firebase_bom)

    //Glide
    implementation(Dependencies.Glide.glide)

    //DotsIndicator
    implementation(Dependencies.DotsIndicator.dots_indicator)
}