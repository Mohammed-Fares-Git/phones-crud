package com.mohammedfares.phones.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.mohammedfares.phones.data.Phone
import com.mohammedfares.phones.dh
import com.mohammedfares.phones.ui.Screen

@Composable
fun PhoneGridItem(nav: NavHostController, phone: Phone) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .clickable {
                       nav.navigate(Screen.Details.route)
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Box (
            modifier = Modifier.height(200.dp)
        ) {

            AsyncImage(model = phone.image, contentDescription = phone.name)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startX = 350f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomStart
            ){

                Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = phone.name,
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.Underline
                    )

                    Text(
                        text = phone.price.dh("$"),
                        color = Color.LightGray,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        textDecoration = TextDecoration.Underline
                    )
                }


            }
        }
    }
}