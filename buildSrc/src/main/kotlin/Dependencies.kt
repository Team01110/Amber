object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val google_service = "com.google.gms.google-services"
    }

    object Kotlin {
        const val java_library = "java-library"
        const val android = "org.jetbrains.kotlin.android"
        const val jvm = "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }

    object Google {
        const val google_service_auth =
            ("com.google.android.gms:play-services-auth:${Versions.google_service_auth}")
        const val google_service = ("com.google.gms:google-services:${Versions.google_service}")
    }
}

object Dependencies {
    object UI {
        const val core = ("androidx.core:core-ktx:${Versions.core}")
        const val appcompat = ("androidx.appcompat:appcompat:${Versions.appcompat}")
        const val material = ("com.google.android.material:material:${Versions.material}")
        const val constraintlayout =
            ("androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}")
        const val viewmodel = ("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}")
        const val fragment = ("androidx.fragment:fragment-ktx:${Versions.fragment}")
        const val stdlib = ("org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}")
        const val junit = ("junit:junit:${Versions.junit}")
        const val test_junit = ("androidx.test.ext:junit:${Versions.test_junit}")
        const val espresso = ("androidx.test.espresso:espresso-core:${Versions.espresso}")
    }

    object Retrofit {
        const val retrofit = ("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        const val converter = ("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
    }

    object Firebase {
        const val firebase_bom = ("com.google.firebase:firebase-bom:${Versions.firebase}")
        const val firebase_auth =
            ("com.google.firebase:firebase-auth-ktx:${Versions.firebase_auth}")
        const val firebase_firestore =
            ("com.google.firebase:firebase-firestore-ktx:${Versions.firebase_firestore}")
        const val firebase_storage =
            ("com.google.firebase:firebase-storage-ktx:${Versions.firebase_storage}")
    }

    object Room {
        const val room_runtime = ("androidx.room:room-runtime:${Versions.room}")
        const val room_ktx = ("androidx.room:room-ktx:${Versions.room}")
        const val room_compiler = ("com.google.dagger:hilt-compiler:${Versions.room}")
    }

    object Glide {
        const val glide = ("com.github.bumptech.glide:glide:${Versions.glide}")
    }

    object DaggerHilt {
        const val hilt = ("com.google.dagger:hilt-android:${Versions.daggerHilt}")
        const val hilt_compiler = ("com.google.dagger:hilt-compiler:${Versions.daggerHilt}")
    }

    object Coroutine {
        const val coroutines =
            ("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
        const val coroutinescore =
            ("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinescore}-Beta")
    }

    object Nav {
        const val navigation_fragment =
            ("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}")
        const val navigation = ("androidx.navigation:navigation-ui-ktx:${Versions.navigation}")
    }

    object viewpager2 {
        const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
    }

    object DotsIndicator {
        const val dots_indicator = ("com.tbuonomo:dotsindicator:${Versions.dots_indicator}")
    }

    object Google {
        const val google_service_auth =
            ("com.google.android.gms:play-services-auth:${Versions.google_service_auth}")

        const val google_service = ("com.google.gms:google-services:${Versions.google_service}")
    }
}

object Versions {

    //ui impl
    const val core = "1.8.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintlayout = "2.1.4"
    const val viewmodel = "2.6.0"
    const val fragment = "1.5.5"
    const val stdlib = "1.8.10"
    const val junit = "4.13.2"
    const val test_junit = "1.1.5"
    const val espresso = "3.5.1"

    //plugins
    const val AGP = "7.4.2"
    const val daggerHilt = "2.45"
    const val kotlin = "1.8.0"
    const val kotlin_jvm = "1.8.0"

    //other impl
    const val retrofit = "2.9.0"
    const val room = "2.5.0"
    const val firebase = "31.4.0"
    const val firebase_auth = "21.3.0"
    const val firebase_firestore = "24.4.5"
    const val firebase_storage = "20.1.0"
    const val glide = "4.15.0"
    const val coroutines = "1.6.4"
    const val coroutinescore = "1.7.0"
    const val navigation = "2.5.3"
    const val viewpager2 = "1.0.0"
    const val dots_indicator = "4.3"
    const val google_service_auth = "20.5.0"
    const val google_service = "4.3.15"

}