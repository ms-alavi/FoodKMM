import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version "1.5.10"
    id("com.android.library")
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies{
                implementation("io.ktor:ktor-client-core:1.5.2")
                implementation("io.ktor:ktor-client-serialization:1.5.2")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
                implementation("com.squareup.sqldelight:runtime:1.4.3")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies{
                implementation("io.ktor:ktor-client-android:1.5.2")
                implementation("com.squareup.sqldelight:android-driver:1.4.3")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.5.2")
                implementation("com.squareup.sqldelight:native-driver:1.4.3")
            }
        }
        val iosTest by getting
    }
}
sqldelight {
    database("RecipeDatabase") {
        packageName = "com.codingwithmitch.food2forkkmm.datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}

android {
    compileSdkVersion(32)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(32)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}