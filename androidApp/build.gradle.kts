
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.5.10"
}



android {
    compileSdkVersion(32)
    defaultConfig {
        applicationId = "com.example.foodkmm.android"
        minSdkVersion(21)
        targetSdkVersion(32)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta09"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation( "com.google.accompanist:accompanist-coil:0.13.0")
    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation("androidx.compose.runtime:runtime:1.2.0-alpha08")
    implementation("androidx.compose.runtime:runtime-livedata:1.2.0-alpha08")
    implementation("androidx.compose.ui:ui:1.2.0-alpha08")
    implementation("androidx.compose.material:material:1.2.0-alpha08")
    implementation("androidx.compose.ui:ui-tooling:1.2.0-alpha08")
    implementation("androidx.compose.foundation:foundation:1.2.0-alpha08")
    implementation("androidx.compose.compiler:compiler:1.2.0-alpha08")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")
    implementation("androidx.activity:activity-compose:1.6.0-alpha01")
    implementation( "androidx.navigation:navigation-compose:2.5.0-beta01")

    implementation("com.google.android.material:material:1.5.0")
    implementation("com.google.dagger:hilt-android:2.37")
    implementation("androidx.hilt:hilt-navigation:1.0.0")
    kapt("com.google.dagger:hilt-compiler:2.37")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")

    implementation("io.ktor:ktor-client-android:1.5.2")

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.7")
}