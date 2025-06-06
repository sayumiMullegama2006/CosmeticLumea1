package com.example.cosmeticlumea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.R
import com.example.cosmeticlumea.Routes // Import Routes object
import com.example.cosmeticlumea.ui.common.CustomOutlinedTextField
import com.example.cosmeticlumea.ui.common.PrimaryButton
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme
import com.example.cosmeticlumea.ui.theme.LoginScreenBackground // Import the background color

@Composable
fun LoginScreen(navController: NavController) {
    var usernameOrEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LoginScreenBackground) // Pink background from Color.kt
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp), // Overall horizontal padding
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp)) // Space from top

            // Lumea Logo with Cosmetics Image
            Image(
                painter = painterResource(id = R.drawable.login_logo_cosmetics), // Your logo image
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(150.dp), // Adjust size as needed
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Welcome Back! Text
            Text(
                text = stringResource(R.string.login_welcome_back),
                style = MaterialTheme.typography.headlineSmall, // Uses adjusted font from Type.kt
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Username or Email Field
            CustomOutlinedTextField(
                value = usernameOrEmail,
                onValueChange = { usernameOrEmail = it },
                label = stringResource(R.string.login_username_email_hint),
                leadingIconResId = R.drawable.ic_person // Using a drawable for icon
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            CustomOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = stringResource(R.string.login_password_hint),
                isPassword = true,
                leadingIconResId = R.drawable.ic_lock // Using a drawable for icon
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Forgot Password?
            TextButton(
                onClick = { /* Handle forgot password click */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = stringResource(R.string.login_forgot_password),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary, // Pink color
                        fontWeight = FontWeight.Medium,
                        textDecoration = TextDecoration.Underline // Underline for link appearance
                    )
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            // Sign In Button
            PrimaryButton(
                text = stringResource(R.string.login_sign_in_button),
                onClick = { /* Handle Sign In */ }
            )
            Spacer(modifier = Modifier.height(24.dp))

            // OR Continue with divider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Divider(
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    thickness = 1.dp
                )
                Text(
                    text = stringResource(R.string.login_or_continue_with),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Divider(
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    thickness = 1.dp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Social Login Buttons (Google, Facebook)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Google Button
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google_icon), // Google icon
                        contentDescription = stringResource(R.string.icon_content_description),
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))
                // Facebook Button
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook_icon), // Facebook icon
                        contentDescription = stringResource(R.string.icon_content_description),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))

            // Create An Account? Sign Up
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.login_no_account_prompt),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                TextButton(
                    onClick = { /* Handle Sign Up navigation */
                        navController.navigate(Routes.REGISTER_SCREEN) // Navigate to register screen
                    }
                ) {
                    Text(
                        text = stringResource(R.string.login_sign_up_link),
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = MaterialTheme.colorScheme.primary, // Pink color
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    CosmeticLumeaTheme {
        LoginScreen(navController = rememberNavController())
    }
}