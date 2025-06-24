package com.andrek.trabavancada

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview
@Composable
fun DiceRollerScreen(navController: NavController){
    DiceRollerScreenApp(navController)
}

@Composable
fun DiceRollerScreenApp(navController: NavController,modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)){
    var resultHome by remember { mutableStateOf(1) }
    var resultAway by remember { mutableStateOf(1) }
    var firstTime by remember { mutableStateOf(true) }
    var defaultText by remember { mutableStateOf(" ") }

    val imageResourceHome = imageResourceDice(resultHome)
    val imageResourceAway = imageResourceDice(resultAway)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(

        ){
                Image(
                    painter = painterResource(imageResourceHome),
                    contentDescription = resultHome.toString()
                )

                Image(
                    painter = painterResource(imageResourceAway),
                    contentDescription = resultAway.toString()
                )
        }

        Text(defaultText, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        if (!firstTime) {
            if (resultAway < resultHome) {
                defaultText = "Player 1 Ganhou"
            } else if (resultHome < resultAway) {
                defaultText = "Player 2 Ganhou"
            } else {
                defaultText = "Empate"
            }
        }

        Spacer(modifier = Modifier.height(46.dp))
        Button(onClick = {
            resultHome = (1..6).random()
            resultAway = (1..6).random()
            firstTime = false
        },modifier = Modifier.width(300.dp).height(100.dp)) {
            Text("Lançar Dados", fontSize = 32.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("main")
        },modifier = Modifier.width(300.dp).height(100.dp)) {
            Text("Home", fontSize = 32.sp)
        }


    }
}

fun imageResourceDice(result: Int):Int{
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    return imageResource
}