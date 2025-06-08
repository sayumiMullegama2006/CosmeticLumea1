// File: app/src/main/java/com/example/cosmeticlumea/ui/screens/SplashScreen.kt
package com.example.cosmeticlumea.ui.screens

import android.content.res.Configuration
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size // Import for size modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image // Import for Image composable
import androidx.compose.ui.res.painterResource // Import for painterResource
import androidx.compose.ui.unit.dp // Import for dp units
import com.example.cosmeticlumea.R // Ensure R is imported for drawables

@Composable
fun SplashScreen(navController: NavController) {
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        // Fade in
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1500) // Fade in duration
        )
        // Hold for a moment
        delay(1000L) // Adjust this duration as needed

        // Fade out
        alpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1500) // Fade out duration
        )
        // Wait for the fade out to complete before navigating
        delay(500L) // Short delay to ensure fade out is visible

        navController.navigate(Routes.ONBOARDING_SCREEN) {
            popUpTo(Routes.SPLASH_SCREEN) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        // Your App Logo
        Image(
            painter = painterResource(id = R.drawable.lumea_logo), // Replace with your logo's drawable ID
            contentDescription = "Lumea App Logo",
            modifier = Modifier
                .size(500.dp) // Adjust size as needed
                .alpha(alpha.value) // Apply the animated alpha
        )
    }
}

