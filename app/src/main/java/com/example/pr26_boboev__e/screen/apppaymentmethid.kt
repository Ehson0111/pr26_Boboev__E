package com.example.pr26_boboev__e.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr26_boboev__e.R
import com.example.pr26_boboev__e.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addpaymentmethod(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Add Payment method",
                        fontSize = 22.sp,
                        color = colorResource(R.color.text),
                    )
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = { navController.navigate(Screen.mainscrenn.route)}
                ) {
                    Image(
                        painter = painterResource(R.drawable.arrow_square_right),
                        contentDescription = "Back"
                    )
                }
            },
            modifier = Modifier.shadow(10.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        val radioOptions = listOf(
            Pair("Pay with wallet", "Complete the payment using your e-wallet"),
            Pair("Credit / Debit Card", "Complete the payment using your debit card")
        )
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

        // Состояния для отображения вложенных радиокнопок
        val additionalOptions =
            remember { mutableStateOf(listOf("**** **** 3323", "**** **** 4456")) }
        val (selectedAdditionalOption, onAdditionalOptionSelected) = remember {
            mutableStateOf<String?>(
                null
            )
        }

        Column(modifier = Modifier.padding(top = 80.dp)) {
            radioOptions.forEach { option ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .height(
                            if (option == selectedOption && option == radioOptions[1]) {
                                if (additionalOptions.value.isNotEmpty()) 350.dp else 100.dp
                            } else 100.dp
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(2.dp),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        // Основной радиоэлемент
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (option == selectedOption),
                                    onClick = { onOptionSelected(option) }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (option == selectedOption),
                                onClick = { onOptionSelected(option) }
                            )
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = option.first,
                                    fontSize = 18.sp,
                                    color = Color.Black
                                )
                                Text(
                                    text = option.second,
                                    fontSize = 14.sp,
                                    color = colorResource(R.color.text1)
                                )
                            }
                        }

                        // Вложенные радиокнопки, если выбрана вторая основная опция
                        if (option == selectedOption && option == radioOptions[1]) {
                            additionalOptions.value.forEach { additionalOption ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp, horizontal = 16.dp)
                                        .height(80.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    ),
                                    elevation = CardDefaults.cardElevation(10.dp),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = (additionalOption == selectedAdditionalOption),
                                            onClick = { onAdditionalOptionSelected(additionalOption) }
                                        )
                                        Column(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(start = 16.dp),
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = additionalOption,
                                                fontSize = 16.sp,
                                                color = Color.Black
                                            )

                                        }
                                        IconButton(
                                            onClick = {
                                                additionalOptions.value =
                                                    additionalOptions.value - additionalOption
                                            }
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.iconoir_trash), // Замените на ваш ресурс
                                                contentDescription = "Delete"
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 130.dp, start = 15.dp, end = 15.dp),

            ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth() // Границы кнопки
                    .height(60.dp) ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.text2), // Цвет фона кнопки
                ),

            ) {
                Text("Proceed to pay",color=Color.White)
            }
        }
    }
}

@Composable
fun trackingpackage(){

}