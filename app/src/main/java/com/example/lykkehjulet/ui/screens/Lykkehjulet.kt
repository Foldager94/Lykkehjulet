package com.example.lykkehjulet.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine


import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lykkehjulet.data.LykkehjuletViewModel
import kotlin.random.Random

@Composable
fun Lykkehjulet(ViewModel: LykkehjuletViewModel) {
    ScreenSetup() {
        WordToGuess(ViewModel.hashWord)
        Infobar(totalLife = ViewModel.lifeTotal, totalPoints = ViewModel.pointTotal)
        Alert(ViewModel)
        Wheel(ViewModel)
        WordPicker(ViewModel)
    }
}



@Composable
fun ScreenSetup(content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}
@Composable
fun WordToGuess(word:String, modifier:Modifier = Modifier){
    Row(modifier = modifier
        .fillMaxHeight(0.1f)
        .fillMaxWidth()
        .border(1.dp, Color.Black, shape = RoundedCornerShape(20)),
        horizontalArrangement = Arrangement.Center){
        Text(text = word, fontSize = 30.sp,
            textAlign = TextAlign.Center)
    }
}
@Composable
fun Infobar(totalLife:Int, totalPoints:Int, modifier:Modifier = Modifier){
    Row(modifier = Modifier
        .fillMaxHeight(0.030f)
        .fillMaxWidth(1f)){
        CategoryOfWord()
        PointTotal(totalPoints)
        LifeTotal(totalLife)
    }

}
@Composable
fun Alert(viewModel: LykkehjuletViewModel){
    Row(modifier = Modifier.fillMaxHeight(0.050f), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
        Text(viewModel.alert, color = Color.Red )
    }
}
@Composable
fun Wheel(viewModel: LykkehjuletViewModel) {
    Row(modifier = Modifier
        .fillMaxHeight(0.4f)) {
        Text(text = viewModel.wheelText)
    }
    Row(modifier = Modifier
        .fillMaxHeight(0.20f)) {
        Button(onClick = {
            if (!viewModel.hasWheelBeenSpined) {
                viewModel.spineWheel()
                viewModel.hasWheelBeenSpined = true
                viewModel.alert = ""
            }else{
                viewModel.alert = "Du skal vælge en konsunant"
            }
        }) {
            Text(text = "Drej Hjulet", textAlign = TextAlign.Center)
        }
    }
}
@Composable
fun WordPicker(viewModel: LykkehjuletViewModel) {
    Row(modifier = Modifier
        .fillMaxHeight(0.18f)) {
        Button(onClick = {
            viewModel.buyLetter = !viewModel.buyLetter
        }) {
            Text(text = "Køb\nVokal", textAlign = TextAlign.Center)
        }
    }
    Row(modifier = Modifier
        .fillMaxHeight(1f)) {
        if (viewModel.buyLetter) {
            Vowels(viewModel)
        } else {
            Consonants(viewModel)
        }
    }
}

@Composable
fun CategoryOfWord(modifier:Modifier = Modifier){
    Column(modifier = Modifier.fillMaxWidth(0.33f),  horizontalAlignment = Alignment.Start) {
        Text("Kategori: Person", fontSize = 15.sp,
            textAlign = TextAlign.Center)
    }
}
@Composable
fun LifeTotal(totalLife:Int){
    Column(modifier = Modifier.fillMaxWidth(1f),  horizontalAlignment = Alignment.End) {
        Text(text = "Liv: $totalLife", fontSize = 15.sp,
            textAlign = TextAlign.Center)
    }
}
@Composable
fun PointTotal(totalPoints:Int){
    Column(modifier = Modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Points: $totalPoints", fontSize = 15.sp,
            textAlign = TextAlign.Center)
    }
}
@Composable
fun Consonants(viewModel: LykkehjuletViewModel, modifier:Modifier = Modifier){

    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(0.25f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawConsuantlLetter("B", viewModel)
        drawConsuantlLetter("G", viewModel)
        drawConsuantlLetter("L", viewModel)
        drawConsuantlLetter("Q", viewModel)
        drawConsuantlLetter("V", viewModel)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(0.33f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawConsuantlLetter("C", viewModel)
        drawConsuantlLetter("H", viewModel)
        drawConsuantlLetter("M", viewModel)
        drawConsuantlLetter("R", viewModel)
        drawConsuantlLetter("W", viewModel)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawConsuantlLetter("D", viewModel)
        drawConsuantlLetter("J", viewModel)
        drawConsuantlLetter("N", viewModel)
        drawConsuantlLetter("S", viewModel)
        drawConsuantlLetter("X", viewModel)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(1f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawConsuantlLetter("F", viewModel)
        drawConsuantlLetter("K", viewModel)
        drawConsuantlLetter("P", viewModel)
        drawConsuantlLetter("T", viewModel)
        drawConsuantlLetter("Z", viewModel)
    }
}
@Composable
fun Vowels(viewModel: LykkehjuletViewModel, modifier: Modifier = Modifier){
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(0.33f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawVowelLetter("A", viewModel)
        drawVowelLetter("O", viewModel)
        drawVowelLetter("Æ", viewModel)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawVowelLetter("E", viewModel)
        drawVowelLetter("U", viewModel)
        drawVowelLetter("Ø", viewModel)

    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth(1f), horizontalAlignment = Alignment.CenterHorizontally) {
        drawVowelLetter("I", viewModel)
        drawVowelLetter("Y", viewModel)
        drawVowelLetter("Å", viewModel)
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun drawVowelLetter(letter:String, viewModel: LykkehjuletViewModel, modifier:Modifier = Modifier){
    var alphaValue by remember { mutableStateOf(1f) }
    if(viewModel.getIsClicked(letter)){
        alphaValue = 0f
    }
    Card(
        modifier = modifier
            .width(40.dp)
            .height(40.dp)
            .alpha(alphaValue),
        border = BorderStroke(2.dp,Color.Black),
        backgroundColor = Color.LightGray,
        onClick = {
            if (!viewModel.getIsClicked(letter) && viewModel.pointTotal >=500){
                viewModel.buyVowel(letter)
                viewModel.setIsClicked(letter)
                viewModel.alert = ""
            }else{
                viewModel.alert = "Du har ikke nok point til at købe en Vokal"
            }
            } ){
        Text(text = letter, fontSize = 20.sp, textAlign = TextAlign.Center)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun drawConsuantlLetter(letter:String, viewModel: LykkehjuletViewModel, modifier:Modifier = Modifier){
    var alphaValue by remember { mutableStateOf(1f) }
    if(viewModel.getIsClicked(letter)){
        alphaValue = 0f
    }
    Card(
        modifier = modifier
            .width(40.dp)
            .height(40.dp)
            .alpha(alphaValue),
        border = BorderStroke(2.dp,Color.Black),
        backgroundColor = Color.LightGray,
        onClick = {
            if (!viewModel.getIsClicked(letter) && viewModel.hasWheelBeenSpined){
                viewModel.guessConsunant(letter)
                viewModel.setIsClicked(letter)
                viewModel.hasWheelBeenSpined = false
                viewModel.alert = ""
            }else{
                viewModel.alert = "Du skal dreje hjulet før du kan vælge et bogstav"
            }
        } ){
        Text(text = letter, fontSize = 20.sp, textAlign = TextAlign.Center)
    }
}