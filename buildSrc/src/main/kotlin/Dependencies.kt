const val kotlinVersion = "1.3.21"

object Build {
    object Versions {
        const val buildToolsVersion = "3.4.2"
        const val googleServicesVersion = "4.2.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val googleServicesPlugin =
        "com.google.gms:google-services:${Versions.googleServicesVersion}"

}

object Pluggins{
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val googleServices = "com.google.gms.google-services"
}
object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
    const val buildToolsVersion = "29.0.2"
}

//Flavors
private object Orange {
    const val dimension = "version"
    const val applicationIdSuffix = ".orange"
    const val versionCode = 1
    const val versionName = "1.0"
}

private object Blue{
    const val dimension = "version"
    const val applicationIdSuffix = ".blue"
    const val versionCode = 1
    const val versionName = "1.0"
}

//Librarias
object Libraries {
    private object Versions {
        //Android X
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val recyclerview = "1.0.0"
        const val cardView = "1.0.0"
        //AndroidX ktx
        const val ktx = "1.1.0"
        //Material
        const val material = "1.0.0"
        //Firebase
        const val firebaseFirestore = "21.1.1"
        //Koin
        const val koin = "2.0.1"
        //Lottie
        const val lottie = "3.0.7"
        //RX
        const val rxjava = "2.2.10"
        const val rxkotlin = "2.4.0"
        const val rxandroid = "2.1.1"
    }

    //Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    //AndroidX
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardView}"
    //AndroidX Ktx
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    //Material
    const val material = "com.google.android.material:material:${Versions.material}"
    //Firebase
    const val firebaseFirestore =
        "com.google.firebase:firebase-firestore:${Versions.firebaseFirestore}"
    //Koin
    const val koin = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    //Lottie
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    //RX
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
}