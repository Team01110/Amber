plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
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

    implementation(Dependencies.UI.core)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraintlayout)
    implementation(Dependencies.UI.viewmodel)
    implementation(Dependencies.UI.fragment)
    implementation(Dependencies.UI.stdlib)
    testImplementation(Dependencies.UI.junit)
    androidTestImplementation(Dependencies.UI.test_junit)
    androidTestImplementation(Dependencies.UI.espresso)
    implementation(project(":domain"))

    //Hilt
    implementation(Dependencies.DaggerHilt.hilt)
    implementation(Dependencies.DaggerHilt.hilt_compiler)

    //Coroutine
    implementation(Dependencies.Coroutine.coroutines)

    //ViewPager2
    implementation(Dependencies.viewpager2.viewpager2)

    //Navigation
    implementation(Dependencies.Nav.navigation_fragment)
    implementation(Dependencies.Nav.navigation)

    //Firebase
    implementation(Dependencies.Firebase.firebase_bom)

    //Glide
    implementation(Dependencies.Glide.glide)

}