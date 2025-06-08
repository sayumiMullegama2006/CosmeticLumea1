package com.example.cosmeticlumea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.ui.screens.OnboardingScreen
import com.example.cosmeticlumea.ui.screens.SplashScreen // 1. IMPORT SplashScreen
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 3. (IMPORTANT) Add this back for a modern, edge-to-edge UI
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CosmeticLumeaApp()
        }
    }
}

@Composable
fun CosmeticLumeaApp() {
    CosmeticLumeaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            // 2. SET the startDestination to SPLASH_SCREEN
            NavHost(navController = navController, startDestination = Routes.SPLASH_SCREEN) {
                // The order of composables here does not matter,
                // only the startDestination does.
                composable(Routes.SPLASH_SCREEN) {
                    SplashScreen(navController = navController)
                }
                composable(Routes.ONBOARDING_SCREEN) {
                    OnboardingScreen(navController = navController)
                }
                // Add other screens like Login, Register here
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CosmeticLumeaApp()
}