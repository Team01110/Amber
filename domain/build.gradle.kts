plugins {
    id (Plugins.Kotlin.java_library)
    id (Plugins.Kotlin.jvm)
}
dependencies{
    //Coroutine
    implementation (Dependencies.Coroutine.coroutines)
}
java {
    sourceCompatibility  = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}