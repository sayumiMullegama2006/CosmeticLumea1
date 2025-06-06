package com.example.cosmeticlumea.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // For "Lumea" brand name on Login/Splash
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default, // Default, but you can set a custom font here (see instructions below)
        fontWeight = FontWeight.Black, // Extra bold for brand name
        fontSize = 40.sp, // Larger for prominence
        lineHeight = 48.sp,
        letterSpacing = 0.sp
    ),
    // For Onboarding Title & "Welcome Back!"
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default, // Default, or custom font
        fontWeight = FontWeight.ExtraBold, // Very bold
        fontSize = 30.sp, // Slightly larger for impact
        lineHeight = 38.sp,
        letterSpacing = 0.sp
    ),
    // For general body text/descriptions (Onboarding, Login hints)
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    // For smaller body text (e.g., "Forgot Password?", "OR Continue with")
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    // For button text
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp, // Slightly larger for button text
        lineHeight = 22.sp,
        letterSpacing = 0.1.sp
    ),
    // For smaller clickable text like "Sign Up"
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold, // Bold for clickable links
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)