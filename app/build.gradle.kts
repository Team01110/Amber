plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
    api(project(":domain"))
    api(project(":data"))

    //google
    implementation(Dependencies.Google.google_service_auth)

    //Hilt
    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.hilt_compiler)

    //Room
    implementation(Dependencies.Room.room_runtime)
    implementation(Dependencies.Room.room_ktx)
    kapt(Dependencies.Room.room_compiler)

    //Coroutine
    implementation(Dependencies.Coroutine.coroutines)
    implementation(Dependencies.Coroutine.coroutinescore)

    //ViewPager2
    implementation(Dependencies.viewpager2.viewpager2)

    //Navigation
    implementation(Dependencies.Nav.navigation_fragment)
    implementation(Dependencies.Nav.navigation)

    //Firebase
    implementation(Dependencies.Firebase.firebase_auth)
    implementation(Dependencies.Firebase.firebase_bom)
//    implementation (Dependencies.Firebase.firebase_firestore)
//    implementation (Dependencies.Firebase.firebase_storage)


    //Glide
    implementation(Dependencies.Glide.glide)

    //Splash
    implementation("androidx.core:core-splashscreen:1.0.0")

    //DotsIndicator
    implementation(Dependencies.DotsIndicator.dots_indicator)

}