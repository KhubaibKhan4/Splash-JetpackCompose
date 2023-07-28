package com.codespacepro.splashscreen

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash")
    object Home : Screen(route = "home")

}
