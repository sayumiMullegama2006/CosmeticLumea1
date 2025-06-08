package com.example.cosmeticlumea.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.R // Assuming R class will be generated
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

@Composable
fun OnboardingScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    // Placeholder for image resource ID
    // In a real app, you would have different images or layouts
    val backgroundImageRes = if (isLandscape) {
        R.drawable.onboarding_landscape // Placeholder
    } else {
        R.drawable.onboarding_portrait // Placeholder
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = backgroundImageRes), // This will cause an error if not available
            contentDescription = "Onboarding Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to CosmeticLumea", // Replace with stringResource if needed
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer // Or a color that contrasts with image
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your one-stop shop for beauty products.", // Replace with stringResource
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer // Or a color that contrasts
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { navController.navigate(Routes.Login.route) },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(text = "Next")
            }
            Spacer(modifier = Modifier.height(48.dp)) // Added space at the bottom
        }
    }
}

// Minimal Routes.kt for compilation
// package com.example.cosmeticlumea
// object Routes {
//     object Login { const val route = "login" }
//     object Onboarding { const val route = "onboarding" }
// }

@Preview(name = "Portrait Mode", showBackground = true)
@Preview(name = "Landscape Mode", showBackground = true, widthDp = 720, heightDp = 360)
@Composable
fun OnboardingScreenPreview() {
    CosmeticLumeaTheme {
        Surface {
            // In Preview, NavController isn't easily available.
            // We can pass a dummy one or structure code to make NavController optional for preview.
            // For simplicity, creating a dummy one for preview.
            OnboardingScreen(navController = rememberNavController())
        }
    }
}
