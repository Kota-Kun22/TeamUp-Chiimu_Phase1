package com.example.lottieanimation_splashscreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun OnboardingScreen(navController: NavHostController)
{
    val animations = listOf(
        R.raw.study,
        R.raw.hustle,
        R.raw.group
    )
    val title= listOf(
        "Explore the Skies",
        "Escape the old-ways to make team",
        "let's bring a Change ",
    )
     val description= listOf(
         "No issues if your are noob we got your back..",
         "Want your idea to become reality hop in....",
         "Let's build a team on which you can rely 共同",
     )
    val pagerState = rememberPagerState{animations.size}

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        HorizontalPager(state = pagerState, Modifier.wrapContentSize()
        ){
            currentPage->
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animations[currentPage]))
                LottieAnimation(
                    composition = composition,
                    iterations =  LottieConstants.IterateForever,
                    modifier= Modifier.size(400.dp)
                )

                Text(
                    text= title[currentPage],
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text= description[currentPage],
                    Modifier.padding(45.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }
        }
        PageIndicator(
            pageCount=animations.size,
            currentPage=pagerState.currentPage,
            modifier=Modifier.padding(60.dp))

    }

}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        repeat(pageCount)
        {
            IndicatorSingleDot(isSelected= it==currentPage)

        }

    }

}

@Composable
fun IndicatorSingleDot(isSelected: Boolean) {
    val widthOfSingleDot= animateDpAsState(targetValue = if(isSelected) 35.dp else 15.dp,label ="")
    Box(modifier=Modifier.padding(3.dp)
        .height(15.dp)
        .width(widthOfSingleDot.value)
        .clip(CircleShape)
        .background(if(isSelected) Color(0xFFE92F1E) else Color(0x52FD5F5F))
    )
    {
        
    }
    

}

