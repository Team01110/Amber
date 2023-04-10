plugins {
    id (Plugins.AGP.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
//    id (Plugins.DaggerHilt.hilt)
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

    packagingOptions {
         resources.excludes.add("META-INF/versions/9/previous-compilation-data.bin")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation (Dependencies.UI.core)
    implementation (Dependencies.UI.appcompat)
    implementation (Dependencies.UI.material)
    implementation (Dependencies.UI.constraintlayout)
    implementation (Dependencies.UI.viewmodel)
    implementation (Dependencies.UI.fragment)
    implementation (Dependencies.UI.stdlib)
    testImplementation (Dependencies.UI.junit)
    androidTestImplementation (Dependencies.UI.test_junit)
    androidTestImplementation (Dependencies.UI.espresso)
    implementation(project(":domain"))

    //Coroutine
    implementation (Dependencies.Coroutine.coroutines)

    //ViewPager2
    implementation(Dependencies.viewpager2.viewpager2)

    //Navigation
    implementation (Dependencies.Nav.navigation_fragment)
    implementation (Dependencies.Nav.navigation)

//    //Firebase
//    implementation (Dependencies.Firebase.firebase_auth)
    implementation (Dependencies.Firebase.firebase_bom)
//    implementation (Dependencies.Firebase.firebase_firestore)
//    implementation (Dependencies.Firebase.firebase_storage)

    //Glide
    implementation(Dependencies.Glide.glide)

}