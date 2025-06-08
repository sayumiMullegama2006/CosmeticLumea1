package com.example.cosmeticlumea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape // Needed for SocialButton
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.* // Contains Checkbox, CheckboxDefaults, ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.R
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.common.PrimaryButton
import com.example.cosmeticlumea.ui.common.softPinkMistBackground
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme
import com.example.cosmeticlumea.ui.theme.TextLink
import com.example.cosmeticlumea.ui.theme.TextSecondary
import com.example.cosmeticlumea.ui.theme.PrimaryPink
import com.example.cosmeticlumea.ui.common.SocialButton // <--- ADD THIS IMPORT!

// The commented out block "It's generally better to define common Composables..." is fine.
// You do NOT need to define SocialButton here anymore.

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var usernameOrEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    var isAgreed by remember { mutableStateOf(false) }

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
            Spacer(modifier = Modifier.height(64.dp))

            Text(
                text = "Create an Account!",
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
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
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
            Spacer(modifier = Modifier.height(16.dp))

            // Confirm Password Field
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Confirm Password Icon") },
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (confirmPasswordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val description = if (confirmPasswordVisibility) "Hide confirm password" else "Show confirm password"
                    IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
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
            Spacer(modifier = Modifier.height(16.dp))

            // Checkbox and Agreement Text
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isAgreed,
                    onCheckedChange = { isAgreed = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.primary,
                        uncheckedColor = MaterialTheme.colorScheme.outline
                    )
                )
                Text(
                    text = "By clicking the Register button, you agree\nto the public offer",
                    color = TextSecondary,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.clickable { isAgreed = !isAgreed }
                )
            }

            // Create Account Button - Navigation Added
            PrimaryButton(
                text = "Create Account",
                onClick = {
                    // TODO: Implement actual registration logic
                    navController.navigate(Routes.LOGIN_SCREEN) {
                        popUpTo(Routes.REGISTER_SCREEN) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = isAgreed // <--- Button is enabled only if checkbox is checked
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
                    contentDescription = "Google Register",
                    onClick = { /* TODO: Google register */ }
                )
                SocialButton(
                    iconRes = R.drawable.facebook_icon, // Ensure this drawable name is correct
                    contentDescription = "Facebook Register",
                    onClick = { /* TODO: Facebook register */ }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            // I Already Have an Account Login - Navigation Added
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "I Already Have an Account",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Login",
                    color = TextLink,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.LOGIN_SCREEN) {
                            popUpTo(Routes.REGISTER_SCREEN) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    CosmeticLumeaTheme {
        RegisterScreen(rememberNavController())
    }
}