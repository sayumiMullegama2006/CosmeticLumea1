package com.example.cosmeticlumea

object Routes {
    object Onboarding { val route = "onboarding" }
    object Login { val route = "login" }
    object Register { val route = "register" }
    object Home { val route = "home" }
    object Detail {
        const val route = "detail_screen" // Changed to avoid conflict with potential 'detail' keyword
        const val argProductId = "productId"
        // Example: detail_screen/123
        val routeWithArg = "$route/{$argProductId}"
    }
    object Cart { val route = "cart" } // Anticipating
    object Profile { val route = "profile" } // Anticipating
}
