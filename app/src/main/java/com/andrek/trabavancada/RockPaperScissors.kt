package com.andrek.trabavancada

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RockPaperScissorsScreen(navController: NavController){
    RockPaperScissorsScreenApp(navController)
}

@Composable
fun RockPaperScissorsScreenApp(navController: NavController,modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)){
    var resultHome by remember { mutableStateOf(1) }
    var resultAway by remember { mutableStateOf(1) }
    var firstTime by remember { mutableStateOf(false) }
    var defaultText by remember { mutableStateOf("") }
    val imageResourceHome = imageResourceRock(resultHome)
    val imageResourceAway = imageResourceRock(resultAway)

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
        Spacer(modifier = Modifier.height(32.dp))
        Text(defaultText)
        if ((resultHome == 1 && resultAway == 2) || (resultHome == 2 && resultAway == 3) || (resultHome == 3 && resultAway == 1)) {
            defaultText = "Player 2 Ganhou"
        } else if ((resultHome == 2 && resultAway == 1) || (resultHome == 3 && resultAway == 2) || (resultHome == 1 && resultAway == 3)){
            defaultText = "Player 1 Ganhou"
        } else {
            defaultText = "Empate"
        }


        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                resultHome = (1..3).random()
                resultAway = (1..3).random()
                firstTime = true
            }) {
                Text("Lançar Duelo")
            }
            Button(onClick = {
                navController.navigate("main")
            }) {
                Text("Home")
            }
        }


    }
}

fun imageResourceRock(result: Int):Int{
    val imageResource = when (result) {
        1 -> R.drawable.rock
        2 -> R.drawable.paper
        else -> R.drawable.scissors
    }
    return imageResource
}