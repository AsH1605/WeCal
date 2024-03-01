package com.example.calender.presentation.ui.component

import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Weather(
    temp: String,
    sunrise: String,
    sunset: String,
    humidity: String,
    description:String,
    ic: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter)
                .alpha(0.7f),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(androidx.compose.ui.graphics.Color.Companion.White)
        ) {
            Box{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            PaddingValues(
                                top = 30.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 30.dp
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier.weight(1.5f),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = temp,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Sunrise: ${sunrise}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Sunset: ${sunset}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Humidity: ${humidity}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = description,
                                    style = TextStyle(
                                        fontSize = 25.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                painter = painterResource(id = ic),
                                contentDescription = "Weather",
                                modifier = Modifier
                                    .weight(0.5f)
                                    .size(150.dp)
                            )
                        }
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.Transparent)
        ) {
            Box{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            PaddingValues(
                                top = 30.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 30.dp
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier.weight(1.5f).fillMaxWidth(),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = temp,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Sunrise: ${sunrise}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Sunset: ${sunset}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Humidity: ${humidity}",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = description,
                                    style = TextStyle(
                                        fontSize = 25.sp,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                painter = painterResource(id = ic),
                                contentDescription = "Weather",
                                modifier = Modifier
                                    .weight(0.5f)
                                    .size(150.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}