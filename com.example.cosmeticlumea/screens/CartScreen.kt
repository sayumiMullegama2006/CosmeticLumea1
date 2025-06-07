package com.example.cosmeticlumea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeticlumea.data.Product // Reusing Product data class
import com.example.cosmeticlumea.data.sampleProductsList // For sample item
import com.example.cosmeticlumea.ui.theme.CosmeticLumeaTheme

// Simulate a cart - in a real app, this would come from a ViewModel or repository
private val sampleCartItems = mutableStateListOf<Product>()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController) {
    // For demonstration, let's add/remove a sample item to test both states.
    // This is a temporary way to toggle state for preview/testing.
    // In a real app, cart state would be managed more robustly.
    // var showSampleItem by remember { mutableStateOf(true) } // Or manage sampleCartItems directly

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shopping Cart") },
                // Navigation icon can be added if this screen isn't part of main bottom nav flow directly
                // or if it can be accessed from somewhere else.
                // For now, assuming it's part of BottomNav, so no explicit back.
                // If it needs a back button:
                // navigationIcon = {
                //     IconButton(onClick = { navController.popBackStack() }) {
                //         Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                //     }
                // }
            )
        }
    ) { paddingValues ->
        // Simulate adding an item for the "sample" state for preview purposes
        // LaunchedEffect(Unit) {
        // if (sampleCartItems.isEmpty()) { // Add only if empty to avoid duplicates on recomposition
        // sampleCartItems.add(sampleProductsList[0])
        // }
        // }

        if (sampleCartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Your cart is empty.", style = MaterialTheme.typography.headlineSmall)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(sampleCartItems) { product ->
                    CartItemRow(product = product)
                }
                // Potentially a summary section
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Total: ${calculateTotalPrice(sampleCartItems)}", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { /* TODO: Checkout */ }, modifier = Modifier.fillMaxWidth()) {
                        Text("Proceed to Checkout")
                    }
                }
            }
        }
    }
}

@Composable
fun CartItemRow(product: Product) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = product.name,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(product.name, style = MaterialTheme.typography.titleMedium)
            Text(product.price, style = MaterialTheme.typography.bodyMedium)
        }
        // For simplicity, not adding quantity selectors or remove buttons yet
        Text("Qty: 1", style = MaterialTheme.typography.bodyMedium) // Static quantity
    }
}

fun calculateTotalPrice(cartItems: List<Product>): String {
    // This is a very basic price calculation, assuming price is like "€XX.YY"
    val total = cartItems.sumOf {
        it.price.replace("€", "").toDoubleOrNull() ?: 0.0
    }
    return String.format("€%.2f", total)
}


// Previews for both states
@Preview(name = "Cart Screen - Empty", showBackground = true)
@Composable
fun CartScreenEmptyPreview() {
    CosmeticLumeaTheme {
        Surface {
            // Ensure cart is empty for this preview
            sampleCartItems.clear()
            CartScreen(navController = rememberNavController())
        }
    }
}

@Preview(name = "Cart Screen - With Item", showBackground = true)
@Composable
fun CartScreenWithItemPreview() {
    CosmeticLumeaTheme {
        Surface {
            // Ensure cart has an item for this preview
            if (sampleCartItems.isEmpty()) {
                sampleCartItems.add(sampleProductsList[0]) // Add a sample product
                 if(sampleProductsList.size > 1) sampleCartItems.add(sampleProductsList[1]) // Add another for testing total
            }
            CartScreen(navController = rememberNavController())
        }
    }
}
