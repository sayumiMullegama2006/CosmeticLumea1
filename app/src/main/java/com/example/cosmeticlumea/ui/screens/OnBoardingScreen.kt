package com.example.cosmeticlumea.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource // Make sure this is imported
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.R
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.common.PrimaryButton
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

@Composable
fun OnboardingScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    val backgroundImage = if (isPortrait) {
        painterResource(id = R.drawable.onboarding_beauty_model)
    } else {
        painterResource(id = R.drawable.onboarding_beauty_model_landscape) // <-- Add landscape image to `res/drawable`
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = backgroundImage,
            contentDescription = stringResource(R.string.onboarding_image_content_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = if (isPortrait) 24.dp else 36.dp,
                    vertical = if (isPortrait) 32.dp else 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(if (isPortrait) 16.dp else 12.dp))
            Text(
                text = stringResource(R.string.onboarding_title),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.onboarding_description),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(if (isPortrait) 36.dp else 20.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                // These represent pagination dots. You'd typically animate them.
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.outline)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.outline)
                )
            }

            Spacer(modifier = Modifier.height(if (isPortrait) 24.dp else 16.dp))

            PrimaryButton(
                text = stringResource(R.string.onboarding_next_button),
                onClick = { navController.navigate(Routes.LOGIN_SCREEN) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    CosmeticLumeaTheme {
        OnboardingScreen(navController = rememberNavController())
    }
}