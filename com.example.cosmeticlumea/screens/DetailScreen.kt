package com.example.cosmeticlumea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.data.Product // Import from data package
import com.example.cosmeticlumea.data.getProductById // Import from data package
import com.example.cosmeticlumea.data.sampleProductsList // For preview
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, productId: String?) {
    val product = getProductById(productId?.toIntOrNull())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(product?.name ?: "Product Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (product != null) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = product.imageResId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = product.price,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify, // Or TextAlign.Start
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Button(
                    onClick = { /* TODO: Add to cart logic */ },
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text("Add to Cart")
                }
                Spacer(modifier = Modifier.height(16.dp)) // Space at the bottom
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Product not found.", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    CosmeticLumeaTheme {
        Surface {
            // Preview with a sample product
            DetailScreen(navController = rememberNavController(), productId = sampleProductsList[0].id.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenProductNotFoundPreview() {
    CosmeticLumeaTheme {
        Surface {
            DetailScreen(navController = rememberNavController(), productId = "999") // Non-existent ID
        }
    }
}
