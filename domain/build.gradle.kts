plugins {
    id (Plugins.Kotlin.java_library)
    id (Plugins.Kotlin.jvm)
}
java {
    sourceCompatibility  = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(Dependencies.Coroutine.coroutinescore)
    implementation(Dependencies.DaggerHilt.hilt_compiler)
}
