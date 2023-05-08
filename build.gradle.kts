buildscript {
    dependencies {
        classpath(Dependencies.Google.google_service)
        classpath("com.android.tools.build:gradle:8.0.0")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Plugins.AGP.application) version Versions.AGP apply false
    id (Plugins.AGP.library) version Versions.AGP apply false
    id (Plugins.Kotlin.android) version Versions.kotlin apply false
    id (Plugins.DaggerHilt.hilt) version Versions.daggerHilt apply false
    id (Plugins.Kotlin.jvm) version Versions.kotlin_jvm apply false
}