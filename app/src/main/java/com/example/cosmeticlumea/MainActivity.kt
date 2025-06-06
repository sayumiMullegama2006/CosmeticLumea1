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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.screens.LoginScreen // Import LoginScreen
import com.example.cosmeticlumea.screens.OnboardingScreen // Import OnboardingScreen
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            NavHost(navController = navController, startDestination = Routes.ONBOARDING_SCREEN) {
                composable(Routes.ONBOARDING_SCREEN) {
                    OnboardingScreen(navController = navController)
                }
                composable(Routes.LOGIN_SCREEN) {
                    LoginScreen(navController = navController)
                }
                // Add other composable routes here as you create more screens (e.g., RegisterScreen)
                // composable(Routes.REGISTER_SCREEN) { RegisterScreen(navController = navController) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CosmeticLumeaApp()
}