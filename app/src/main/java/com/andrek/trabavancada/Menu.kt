package com.andrek.trabavancada

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MenuScreen(){
    MenuScreenApp()
}

@Composable
fun MenuScreenApp(modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {}) {
            Text("Dice Roller")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {}) {
            Text("Rock Paper Scissors")
        }
    }
}