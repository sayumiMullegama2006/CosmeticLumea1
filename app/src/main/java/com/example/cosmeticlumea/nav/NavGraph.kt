package com.example.cosmeticlumea.nav // Correct package for your nav folder

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.screens.OnboardingScreen
import com.example.cosmeticlumea.ui.screens.SplashScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.ONBOARDING_SCREEN, // Starting point of your app
        modifier = modifier
    ) {
        composable(Routes.ONBOARDING_SCREEN) {
            OnboardingScreen(navController = navController)
        }
        composable(Routes.SPLASH_SCREEN) {
            SplashScreen(navController = navController)
        }


    }
}