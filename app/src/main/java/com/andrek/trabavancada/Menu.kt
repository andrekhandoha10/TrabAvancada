package com.andrek.trabavancada

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    MenuScreenApp(navController)
}

@Composable
fun MenuScreenApp(navController: NavController,modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.mainpage),
            contentDescription = "",
            modifier = Modifier.size(250.dp)
        )

        Text(
            text = "Bem-vindo, \nEscolha o jogo",
            fontSize = 24.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("DiceRoller")
        },modifier = Modifier.width(300.dp).height(100.dp)) {
            Text("Dice Roller", fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("RockPaperScissors")
        },modifier = Modifier.width(300.dp).height(100.dp)) {
            Text("Rock Paper Scissors", fontSize = 24.sp)
        }
    }
}