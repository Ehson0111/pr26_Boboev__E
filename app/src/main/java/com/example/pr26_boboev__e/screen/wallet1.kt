package com.example.pr26_boboev__e.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr26_boboev__e.R
import com.example.pr26_boboev__e.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainscreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Wallet",
                        fontSize = 22.sp,
                        color = colorResource(R.color.text),
                    )
                }
            },
            modifier = Modifier.shadow(10.dp), // Тень текста
            colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            ),

            )
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Image(
                modifier = Modifier.size(60.dp, 60.dp),
                painter = painterResource(R.drawable.frame),
                contentDescription = "D",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Hello Ken ",
                    fontSize = 20.sp,
                    color = colorResource(R.color.text1)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Current balance: ", fontSize = 12.sp,
                        color = colorResource(R.color.text1)
                    )
                    Text(
                        "N10,712:00 ", fontSize = 12.sp,
                        color = colorResource(R.color.text2)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 100.dp, top = 20.dp)
            ) {
                Image(
                    modifier = Modifier.size(20.dp, 20.dp),
                    painter = painterResource(R.drawable.eye_slash),
                    contentDescription = "D"
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .height(210.dp)
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Top up",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 20.sp
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.size(65.dp),
                            onClick = {
                                navController.navigate(Screen.pay.route)
                            }
                        ) {
                            Image(
                                painter = painterResource(R.drawable.frame_91),
                                modifier = Modifier
                                    .size(65.dp) // Увеличенный размер
                                    .padding(8.dp),
                                contentDescription = "Bank",
                                contentScale = ContentScale.Crop
                            )
                        }

                        Text("Bank", fontSize = 16.sp, color = colorResource(R.color.text1))
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.size(65.dp),
                            onClick = {
                                navController.navigate(Screen.pay.route)
                            }
                        ) {
                            Image(
                                painter = painterResource(R.drawable.transfer),
                                modifier = Modifier
                                    .size(65.dp) // Увеличенный размер
                                    .padding(8.dp),
                                contentDescription = "Transfer",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text ("Transfer", fontSize = 16.sp, color = colorResource(R.color.text1))
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.size(65.dp),
                            onClick = {
                                navController.navigate(Screen.pay.route)
                            }
                        ) {
                            Image(
                                painter = painterResource(R.drawable.card),
                                modifier = Modifier
                                    .size(65.dp) // Увеличенный размер
                                    .padding(8.dp),
                                contentDescription = "Card",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text ("Card", fontSize = 16.sp, color = colorResource(R.color.text1))
                    }
                }
            }
        }
        Column(modifier = Modifier.padding(top = 40.dp, start = 15.dp, end = 15.dp)) {
            Text("Transaction History", fontSize = 22.sp)
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                card("-N3,000.00", Color.Red, "Delivery fee", "July 7, 2022")

                card("N2,000.00", Color.Green, "Lalalalala", "July 4, 2022")
                card("-N3,000.00", Color.Red, "Third Delivery", "July 1, 2022")
                card("N1,000.00", Color.Green, "Another One", "July 27, 2022")
                card("N2,500.00", Color.Green, "Experts Are The Best", "July 28, 2022")
                card("N2,500.00", Color.Red, "Experts Are The Best", "July 28, 2022")
                card("N2,500.00", Color.Red, "Experts Are The Best", "July 28, 2022")
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        BottomAppBar(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(88.dp)
                .padding()
                .border(width = 0.1.dp, color = colorResource(R.color.text1)),
            containerColor = Color.White,
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, end = 17.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column() {
                        IconButton(onClick = { /* Handle home click */ }) {
                            Icon(
                                painter = painterResource(R.drawable.house_2),
                                contentDescription = "Home",
                                tint = Color.Unspecified
                            )
                        }
                        Text("Home")
                    }
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.vector),
                            contentDescription = "Search",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable { }
                        )
                    }
                    IconButton(onClick = { navController.navigate(Screen.trackingpackage.route)}) {
                        Icon(
                            painter = painterResource(R.drawable.smart_car),
                            contentDescription = "Settings",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable { }

                        )
                    }
                    IconButton(onClick = { /* Handle settings click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.profile_circle),
                            contentDescription = "Settings",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable { }

                        )
                    }

                }
            }
        )
    }
}

@Composable
fun card(title: String, color: Color, description: String, date: String) {
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .height(90.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(2.dp),
            shape = RoundedCornerShape(0.dp) // Квадратные границы
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        color = color
                    )
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        color = colorResource(R.color.text1)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = date,
                        fontSize = 14.sp,
                        color = colorResource(R.color.text1)
                    )
                }

            }
        }
    }
}
