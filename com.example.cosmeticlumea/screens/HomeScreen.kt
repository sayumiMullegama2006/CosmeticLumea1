package com.example.cosmeticlumea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.R // Assuming R class
import com.example.cosmeticlumea.Routes
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

// Define a simple Product data class
data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val imageResId: Int // Using Int for drawable resource ID
)

// Sample product data
val sampleProducts = listOf(
    Product(1, "Luxury Lipstick", "€25.99", R.drawable.product_placeholder),
    Product(2, "Silk Foundation", "€45.50", R.drawable.product_placeholder),
    Product(3, "Eyeshadow Palette", "€30.00", R.drawable.product_placeholder),
    Product(4, "Nourishing Night Cream", "€55.20", R.drawable.product_placeholder),
    Product(5, "Vitamin C Serum", "€35.00", R.drawable.product_placeholder),
    Product(6, "Organic Mascara", "€19.99", R.drawable.product_placeholder)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // In a real app, this would likely be part of MainScreen with BottomNav
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("CosmeticLumea") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sampleProducts) { product ->
                ProductCard(product = product) {
                    navController.navigate("${Routes.Detail.route}/${product.id}")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = product.imageResId), // Will fail if placeholder doesn't exist
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = product.name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = product.price, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

// Update Routes.kt
// package com.example.cosmeticlumea
// object Routes {
//     // ... other routes
//     object Detail {
//         const val route = "detail"
//         const val argProductId = "productId"
//         val routeWithArg = "$route/{$argProductId}"
//     }
// }

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CosmeticLumeaTheme {
        Surface {
            HomeScreen(navController = rememberNavController())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    CosmeticLumeaTheme {
        Surface {
            ProductCard(product = sampleProducts[0], onClick = {})
        }
    }
}
