package com.example.cosmeticlumea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff // New import for visibility toggle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation // New import for password toggle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.R
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.common.AppLogo
import com.example.cosmeticlumea.ui.common.PrimaryButton
import com.example.cosmeticlumea.ui.common.softPinkMistBackground
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme
import com.example.cosmeticlumea.ui.theme.TextLink
import com.example.cosmeticlumea.ui.theme.TextSecondary
import com.example.cosmeticlumea.ui.theme.PrimaryPink
import com.example.cosmeticlumea.ui.common.SocialButton // <--- ADD THIS IMPORT!


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var usernameOrEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) } // State for password visibility

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .softPinkMistBackground()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            AppLogo()
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Luméa",
                style = MaterialTheme.typography.headlineLarge.copy(color = PrimaryPink),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 8.dp, bottom = 24.dp)
            )

            // Username or Email Field
            OutlinedTextField(
                value = usernameOrEmail,
                onValueChange = { usernameOrEmail = it },
                label = { Text("Username or Email") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Username Icon") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password Icon") },
                // Apply visual transformation based on passwordVisibility state
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = { // Add the eye icon toggle
                    val image = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val description = if (passwordVisibility) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = image, contentDescription = description)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Forgot Password
            Text(
                text = "Forgot Password?",
                color = TextLink,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 8.dp)
                    .clickable {
                        // TODO: Handle forgot password navigation (e.g., navController.navigate(Routes.FORGOT_PASSWORD_SCREEN))
                    }
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Sign In Button - Navigation Added
            PrimaryButton(
                text = "Sign In",
                onClick = {
                    // TODO: Implement actual login logic (API call, validation, etc.)
                    // On successful login, navigate to the Home screen
                    navController.navigate(Routes.HOME_SCREEN) {
                        // This clears the back stack up to the login screen,
                        // so pressing back from Home doesn't go back to Login.
                        popUpTo(Routes.LOGIN_SCREEN) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // OR Continue with -
            Text(
                text = "- OR Continue with -",
                color = TextSecondary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Social Login Buttons (Google, Facebook)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialButton(
                    iconRes = R.drawable.ic_google_logo,
                    contentDescription = "Google Login",
                    onClick = { /* TODO: Google login */ }
                )
                SocialButton(
                    iconRes = R.drawable.facebook_icon,
                    contentDescription = "Facebook Login",
                    onClick = { /* TODO: Facebook login */ }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            // Create an Account? Sign Up - Navigation Added
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Create An Account?",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign Up",
                    color = TextLink,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.REGISTER_SCREEN) // Navigate to Register screen
                    }
                )
            }
        }
    }
}

// Reusing SocialButton here, as it's common UI.
// You might want to move SocialButton to CommonUI.kt if it's used more broadly.
@Composable
fun SocialButton(
    iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(60.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(40.dp) // <<< THIS LINE
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    CosmeticLumeaTheme {
        LoginScreen(rememberNavController())
    }
}