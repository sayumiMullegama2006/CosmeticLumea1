package com.example.cosmeticlumea.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cosmeticlumea.R
import com.example.cosmeticlumea.ui.theme.LightPinkBackground
import com.example.cosmeticlumea.ui.theme.PrimaryPink
import com.example.cosmeticlumea.ui.theme.WhiteBackground

// Extension function for a consistent soft pink mist background gradient
fun Modifier.softPinkMistBackground(): Modifier = this.background(
    Brush.linearGradient(
        colors = listOf(LightPinkBackground, WhiteBackground),
        start = Offset(0f, 0f),
        end = Offset(1f, 1f)
    )
)

@Composable
fun AppLogo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(120.dp) // Smaller for login/register screen
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_logo_cosmetics), // Ensure this resource exists
            contentDescription = "App Logo",
            contentScale = ContentScale.Crop, // Crop to fill the circular shape
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Composable
fun SocialButton(
    iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(60.dp), // Keep button size at 60.dp for now
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface, // Use surface color for background
            contentColor = MaterialTheme.colorScheme.onSurface // Default content color
        ),
        // Reduce default button padding to make the icon appear larger
        contentPadding = PaddingValues(0.dp) // <-- Set content padding to 0.dp
    ) {
        // Use a Box to center the image and allow it to fill
        Box(
            modifier = Modifier.fillMaxSize(), // Box fills the button's content area
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit, // Or ContentScale.Inside if you prefer
                modifier = Modifier
                    .size(50.dp) // Slightly less than button size (60dp - 10dp for slight margin)
                    .clip(CircleShape) // Clip image to circle shape if it's not already
            )
        }
    }
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryPink,
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.medium // Or RoundedCornerShape(8.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.titleLarge)
    }
}
