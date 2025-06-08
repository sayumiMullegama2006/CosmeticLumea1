plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Make sure you have the kotlin-compose plugin defined in libs.versions.toml
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.cosmeticlumea"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cosmeticlumea"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        // These should match your kotlinOptions jvmTarget
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        // --- CRITICAL ADDITION HERE ---
        // This version must be compatible with your Kotlin version and the Compose BOM.
        // For Kotlin 1.9.20 (a common recent version), '1.5.10' is often compatible.
        // If you still have errors, check the official Compose Kotlin compatibility map.
        kotlinCompilerExtensionVersion = "1.5.10" // <-- ADD THIS LINE
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom)) // Keep using your BOM
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Using direct string declarations is okay, but for consistency,
    // you might consider adding these to libs.versions.toml too in the future.
    implementation("androidx.navigation:navigation-compose:2.8.0-beta02") // You chose this beta, keep it
    implementation("androidx.compose.material:material-icons-extended:1.6.7") // This matches Compose 1.6.x
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1") // This matches Compose 1.2.x, might need to align with BOM

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}