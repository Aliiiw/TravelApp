package com.alirahimi.travelapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alirahimi.travelapp.R
import com.alirahimi.travelapp.ui.theme.MyWhite
import com.alirahimi.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(navigationController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HomeHeader()
    }
}

@Composable
fun HomeHeader() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.head),
            contentDescription = "",
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth(), contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .align(Alignment.TopCenter)
                .padding(top = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Good Morning",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                letterSpacing = (-1).sp,
                color = MyWhite,
                style = TextStyle(shadow = Shadow(color = MyWhite, blurRadius = 6f))
            )

            Text(
                text = "What do you want to book Today!",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.2).sp,
                color = MyWhite
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomButton(vector = Icons.Filled.AirplanemodeActive, text = "Flights")
                CustomButton(vector = Icons.Filled.DirectionsCar, text = "Cars")
                CustomButton(vector = Icons.Filled.Business, text = "Hotel")
                CustomButton(vector = Icons.Filled.LocalShipping, text = "Ship")
            }
        }
    }
}

@Composable
fun CustomButton(vector: ImageVector, text: String) {

    Button(
        onClick = {},
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                imageVector = vector,
                contentDescription = ""
            )

            Text(
                text = text, style = TextStyle(
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}