package com.codespacepro.splashscreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var startAnim by remember {
        mutableStateOf(false)
    }

    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnim) 1f else 0f, animationSpec = tween(
            durationMillis = 3000
        ), label = "Alpha Anim"
    )

    LaunchedEffect(key1 = true) {
        startAnim = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    SplashAnimation(alpha = alphaAnim.value)
}

@Composable
fun SplashAnimation(alpha: Float) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.Blue)
            .alpha(alpha),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = Icons.Default.Email,
            contentDescription = "EMAIL",
            tint = Color.White
        )
    }

}


@Composable
@Preview
fun SplashLightPreview() {
    SplashAnimation(1f)
}

