package com.alirahimi.travelapp.screens

import android.widget.ExpandableListView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alirahimi.travelapp.R
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DetailScreen(navigationController: NavController) {

    Column {
        DetailScreenHeader()
    }
}

@Composable
fun DetailScreenHeader() {

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
                    .padding(16.dp)
            ) {

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