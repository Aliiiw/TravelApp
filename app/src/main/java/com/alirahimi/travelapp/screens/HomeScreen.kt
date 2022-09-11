package com.alirahimi.travelapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.alirahimi.travelapp.models.HomeTripModel
import com.alirahimi.travelapp.ui.theme.MyBlue2
import com.alirahimi.travelapp.ui.theme.MyWhite
import com.alirahimi.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(navigationController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            HomeHeader()
        }
        item {
            Text(
                text = "Trending Offers!",
                style = TextStyle(
                    color = MyWhite,
                    fontFamily = OverPassFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(top = 24.dp, start = 12.dp, bottom = 8.dp)
            )
        }

        itemsIndexed(Trips) { position, data ->
            HomeTripItem(homeTripModel = data)

        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }

    }
}

@Composable
fun HomeHeader() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.head),
            contentDescription = "",
            modifier = Modifier
                .height(260.dp)
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
                    .padding(horizontal = 28.dp, vertical = 24.dp),
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
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MyBlue2
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                imageVector = vector,
                contentDescription = "",
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

@Composable
fun HomeTripItem(homeTripModel: HomeTripModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = rememberCoilPainter(request = homeTripModel.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable { }
                .height(200.dp)
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = homeTripModel.dayPerson,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Color(255, 215, 0),
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp)
                    .align(CenterVertically)

            )

            Text(
                text = homeTripModel.rating.toString(),
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }

        Text(
            text = homeTripModel.title,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        )
    }
}

val Trips = listOf<HomeTripModel>(
    HomeTripModel(
        "https://imgcld.yatra.com/ytimages/image/upload/t_holidays_srplist_tablet_hc/v1501843603/DO_NOT_USE_Editorial_Images/Grand_palace_and_Wat_phra_keaw.jpg",
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ),

    HomeTripModel(
        "https://d3hne3c382ip58.cloudfront.net/files/uploads/bookmundi/resized/cmsfeatured/south-india-tour-package-1555403191-785X440.jpg",
        "7 Days / 2 Person",
        "How to get around India on the cheap budget in 2022",
        5.9f
    ),

    HomeTripModel(
        "https://imgcld.yatra.com/ytimages/image/upload/t_holidays_srplist_tablet_hc/v1501843603/DO_NOT_USE_Editorial_Images/Grand_palace_and_Wat_phra_keaw.jpg",
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ),

    HomeTripModel(
        "https://d3hne3c382ip58.cloudfront.net/files/uploads/bookmundi/resized/cmsfeatured/south-india-tour-package-1555403191-785X440.jpg",
        "7 Days / 2 Person",
        "How to get around India on the cheap budget in 2021",
        5.9f
    ),


    HomeTripModel(
        "https://d3hne3c382ip58.cloudfront.net/files/uploads/bookmundi/resized/cmsfeatured/south-india-tour-package-1555403191-785X440.jpg",
        "7 Days / 2 Person",
        "How to get around India on the cheap budget in 2021",
        5.9f
    ),

    HomeTripModel(
        "https://imgcld.yatra.com/ytimages/image/upload/t_holidays_srplist_tablet_hc/v1501843603/DO_NOT_USE_Editorial_Images/Grand_palace_and_Wat_phra_keaw.jpg",
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2021",
        4.8f
    ),
)