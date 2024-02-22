package com.example.lottieanimation_splashscreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController:NavHostController)
{
    val alpha = remember{
        Animatable(0f)
    }
    LaunchedEffect(key1 = true)
    {
        alpha.animateTo(
            1f,
            animationSpec = tween(
                durationMillis = 4000
            )
        )
        delay(3000)
        navController.popBackStack()
        navController.navigate("Onboarding")
    }
    Column(/** sorry for this much space but i like this way*/
        modifier= Modifier
            .fillMaxSize()
            .background(
                if (isSystemInDarkTheme()) {
                    Color.DarkGray
                } else {
                    Color.White
                }
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "WELCOME TO CHIIMU",fontSize = 28.sp, modifier=Modifier.alpha(alpha.value))

        Spacer(modifier=Modifier.height(15.dp))

        LoaderAnimation(modifier=Modifier.size(300.dp),anim =R.raw.group)

        Spacer(modifier=Modifier.height(15.dp))

        Text(
            text = "Lets Build you a Team !!...",
            fontSize = 28.sp,
            modifier=Modifier.alpha(alpha.value))

    }


}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
     val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever,modifier=modifier)


}

