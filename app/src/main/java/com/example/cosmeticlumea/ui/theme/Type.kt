// File: app/src/main/java/com/example/cosmeticlumea/ui/theme/Type.kt
package com.example.cosmeticlumea.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cosmeticlumea.R

// Define font families
val poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val aileron = FontFamily(
    Font(R.font.aileron_regular, FontWeight.Normal),
    Font(R.font.aileron_bold, FontWeight.Bold)
)

// Define typography styles
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = aileron,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    // ... add other text styles as needed
)