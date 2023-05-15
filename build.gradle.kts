buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(Dependencies.Google.google_service)
        val nav_version = "2.5.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Plugins.AGP.application) version Versions.AGP apply false
    id (Plugins.AGP.library) version Versions.AGP apply false
    id (Plugins.Kotlin.android) version Versions.kotlin apply false
    id (Plugins.DaggerHilt.hilt) version Versions.daggerHilt apply false
    id (Plugins.Kotlin.jvm) version Versions.kotlin_jvm apply false
    //id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}