package com.example.cosmeticlumea.data

import com.example.cosmeticlumea.R // Make sure R is imported if not automatically

// Define a simple Product data class
data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val imageResId: Int, // Using Int for drawable resource ID
    val description: String = "This is a fantastic product that you will absolutely love. It has all the features you need and more. Made from the highest quality materials, ensuring durability and a premium feel. Perfect for daily use or as a special gift."
)

// Sample product data
val sampleProductsList = listOf(
    Product(1, "Luxury Lipstick", "€25.99", R.drawable.product_placeholder, "A luxurious lipstick with a creamy matte finish. Provides long-lasting color and hydration. Available in 12 stunning shades."),
    Product(2, "Silk Foundation", "€45.50", R.drawable.product_placeholder, "Lightweight silk foundation that provides flawless coverage and a natural, dewy glow. Suitable for all skin types."),
    Product(3, "Eyeshadow Palette", "€30.00", R.drawable.product_placeholder, "A versatile eyeshadow palette with 18 highly pigmented shades, ranging from mattes to shimmers. Create endless looks for day and night."),
    Product(4, "Nourishing Night Cream", "€55.20", R.drawable.product_placeholder, "A rich and nourishing night cream that repairs and rejuvenates your skin while you sleep. Wake up to softer, smoother, and more radiant skin."),
    Product(5, "Vitamin C Serum", "€35.00", R.drawable.product_placeholder, "Brighten and protect your skin with this potent Vitamin C serum. Helps to reduce dark spots, even out skin tone, and boost collagen production."),
    Product(6, "Organic Mascara", "€19.99", R.drawable.product_placeholder, "Define and lengthen your lashes with this organic mascara. Gentle formula, perfect for sensitive eyes. Smudge-proof and long-lasting.")
)

fun getProductById(productId: Int?): Product? {
    return sampleProductsList.find { it.id == productId }
}
