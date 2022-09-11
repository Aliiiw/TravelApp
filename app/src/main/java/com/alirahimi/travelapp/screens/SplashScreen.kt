package com.alirahimi.travelapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alirahimi.travelapp.R
import com.alirahimi.travelapp.ui.theme.MyGreen
import com.alirahimi.travelapp.ui.theme.MyWhite
import com.alirahimi.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun SplashScreen(navigationController: NavController) {
    val splashImageUrl =
        "https://images.unsplash.com/photo-1512100356356-de1b84283e18?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=709&q=80"
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(16.dp)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Transparent,
                            MyGreen,
                            Color.Transparent
                        )
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Explore New Places",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                letterSpacing = (-1).sp,
                color = MyWhite
            )

            Text(
                text = "Made with ❤️ by Aliiiw",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                letterSpacing = (-1).sp,
                color = MyWhite
            )

            Button(
                onClick = {
                    navigationController.navigate("home")
                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MyGreen,
                    contentColor = MyWhite
                ),
            ) {
                Text(text = "Let's Get Start")
            }
        }
    }
}