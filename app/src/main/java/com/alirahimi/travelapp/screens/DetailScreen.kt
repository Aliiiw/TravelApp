package com.alirahimi.travelapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alirahimi.travelapp.R
import com.alirahimi.travelapp.models.TripDay
import com.alirahimi.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DetailScreen(navigationController: NavController) {

    LazyColumn() {
        item {
            DetailScreenHeader(navigationController = navigationController)
            TripInfoContent()
        }
        itemsIndexed(tripDays) { position, data ->
            TripDayContent(tripDay = data)
        }
    }
}

@Composable
fun TripDayContent(tripDay: TripDay) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = tripDay.title.uppercase(),
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp,
            letterSpacing = 0.75.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = tripDay.detail,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )
    }

}

@Composable
fun DetailScreenHeader(navigationController: NavController) {

    Box {

        Image(
            painter = painterResource(id = R.drawable.beach),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()

        ) {
            CustomButton(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
            ) {
                navigationController.popBackStack()
            }

            CustomButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                imageVector = Icons.Default.BookmarkBorder,
            ) {

            }
        }
    }
}

@Composable
fun CustomButton(
    imageVector: ImageVector,
    modifier: Modifier,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        border = BorderStroke(2.dp, Color(0xFFEAFBFF)),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xDDF6F9FF),
            contentColor = Color(0xFF3562D7)
        ),
        modifier = modifier.then(Modifier.size(48.dp))
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = ""
        )
    }
}

@Composable
fun LocationChip(text: String) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFFBF110))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {

        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "",
            modifier = Modifier
                .padding(end = 4.dp)
                .size(12.dp)
                .align(CenterVertically)
        )

        Text(
            text = text,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.Black
        )
    }

}

@Composable
fun TripDataItem(imageVector: ImageVector, title: String, subtitle: String) {
    Row {
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .size(32.dp)
                .padding(8.dp),
            imageVector = imageVector,
            contentDescription = ""
        )

        Column {

            Text(
                text = title,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp
            )

            Text(
                text = subtitle,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun TripInfoContent() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row {

            LocationChip(text = "North Shore")
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(12.dp)
                    .align(CenterVertically),
                tint = Color(0xFFFBC110)
            )

            Text(
                text = "4.8 (3.5k reviews)",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "How to get around North Shore on a cheap budget in 2022",
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = (-0.2).sp
        )

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TripDataItem(
                imageVector = Icons.Default.CalendarToday,
                title = "Duration",
                subtitle = "7 days"
            )

            TripDataItem(
                imageVector = Icons.Default.Person,
                title = "Package For",
                subtitle = "2 Person"
            )

            TripDataItem(
                imageVector = Icons.Default.AttachMoney,
                title = "Total Cost",
                subtitle = "800"
            )

        }

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

    }

}

var tripDays = listOf(
    TripDay(
        title = "Day 1: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),
    TripDay(
        title = "Day 2: Kanchanaburi",
        detail = "From Bangkok, my next recommended destination is Kanchanaburi. Whilst the name of the town might not instantly ring any bells, the river it sits on probably will, it’s the River Kwai, famous for its bridge, the story of which was turned into a film."
    ),
    TripDay(
        title = "Day 3: Ayutthaya",
        detail = "From Kanchanaburi I’d suggest heading to one of Thailand’s old capital cities. There are two main options to choose from, Ayutthaya and Sukhothai, and on a shorter trip like this, I think picking just one of these two will suffice."
    ),
    TripDay(
        title = "Day 4: Khao Sok",
        detail = "Now it’s time to head south, to one of my favourite spots in Thailand – Khao Sok National Park. This place is, for some reason, not well visited, but it is truly unlike anywhere else I visited in the country."
    ),
)