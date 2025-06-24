package com.andrek.trabavancada

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var firstTime by remember { mutableStateOf(false) }
    val imageResourceHome = imageResourcePut(resultHome)
    val imageResourceAway = imageResourcePut(resultAway)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(

        ){
            // Coluna do Dado Home
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(imageResourceHome),
                    contentDescription = resultHome.toString()
                )
                Text(text = resultHome.toString())
            }

            // Coluna do Dado Away
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(imageResourceAway),
                    contentDescription = resultAway.toString()
                )
                Text(text = resultAway.toString())
            }
        }

        if (firstTime) {
            if (resultAway < resultHome) {
                Text("Player 1 Ganhou")
            } else if (resultHome < resultAway) {
                Text("Player 2 Ganhou")
            } else {
                Text("Empate!")
            }
        }


        Button(onClick = {
            resultHome = (1..6).random()
            resultAway = (1..6).random()
            firstTime = true
        }) {
            Text("Lançar Dados")
        }
        Button(onClick = {
            navController.navigate("main")
        }) {
            Text("Home")
        }


    }
}

fun imageResourcePut(result: Int):Int{
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