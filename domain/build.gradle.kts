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
    implementation(project(":data"))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":data")))
    implementation("androidx.media2:media2-common:1.2.1")
    implementation(project(mapOf("path" to ":data")))
}