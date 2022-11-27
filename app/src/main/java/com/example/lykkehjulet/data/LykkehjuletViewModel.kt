package com.example.lykkehjulet.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LykkehjuletViewModel: ViewModel() {
    var hasWheelBeenSpined by mutableStateOf(false)
    var pointTotal by mutableStateOf(0)
    var wheelPlacement by mutableStateOf("")
    var wheelText by mutableStateOf("")
    var alert by mutableStateOf("")
    var currentPoint by mutableStateOf(0)
    var lifeTotal by mutableStateOf(3)
    var buttonIsClickList by mutableStateOf(mutableStateListOf(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false))
    var word = randomWord()
    var hashWord by mutableStateOf(wordReplaceWithHash(word))
    var buyLetter by mutableStateOf(false)

    fun randomWord(): String {
        val words = listOf("Hej jeg hedder Christoffer", "Jeg er meget sulten", "Hej mor jeg er far")
        val randomIndex = Random.nextInt(words.size)
        return words[randomIndex]
    }

    private fun wheelOutCome(outCome: String){
        when (outCome){
            "100" -> currentPoint = 100
            "300" -> currentPoint = 300
            "500" -> currentPoint = 500
            "600" -> currentPoint = 600
            "800" -> currentPoint = 800
            "1000" -> currentPoint = 1000
            "1500" -> currentPoint = 1500
            "Fallit" -> pointTotal = 0
        }
    }
    private fun wheelOutComeText(outCome: String){
        when (outCome){
            "100" -> wheelText = "Hjulet landte på 100"
            "300" -> wheelText = "Hjulet landte på 300"
            "500" -> wheelText = "Hjulet landte på 500"
            "600" -> wheelText = "Hjulet landte på 600"
            "800" -> wheelText = "Hjulet landte på 800"
            "1000" -> wheelText = "Hjulet landte på 1000"
            "1500" -> wheelText = "Hjulet landte på 1500"
            "Fallit" -> wheelText = "Du er gået falit. Dine point er blevet sat til 0"
        }
    }
    fun spineWheel() {
        val pointList = listOf("100", "100", "300", "500", "500", "500", "500", "500", "600", "600", "800", "800", "800", "800", "800", "1000", "1000", "1500", "Fallit")
        val randomIndex = Random.nextInt(pointList.size)
        wheelPlacement = pointList[randomIndex]
        wheelOutCome(wheelPlacement)
        wheelOutComeText(wheelPlacement)
    }
    fun wordReplaceWithHash(word: String): String {
        var hashWord = ""
        for (char in word) {
            hashWord += if (char == ' ') {
                " "
            } else {
                "#"
            }

        }
        return hashWord
    }
    fun guessConsunant(letter:String){
        var numberOfOcurrences = 0
        val chars = hashWord.toCharArray()
        for ((index, char) in word.withIndex()){
            if (letter.lowercase() == char.toString().lowercase()){
                chars[index] = char
                numberOfOcurrences++
            }
        }
        if (numberOfOcurrences == 0){
            lifeTotal--
        }else{
            pointTotal += numberOfOcurrences * currentPoint
        }
        hashWord = String(chars)
    }
    fun buyVowel(letter:String){
        pointTotal -= 500
        val chars = hashWord.toCharArray()
        for ((index, char) in word.withIndex()) {
            if (letter.lowercase() == char.toString().lowercase()) {
                chars[index] = char
            }
        }
        hashWord = String(chars)
    }
    fun setIsClicked(letter: String){
        when (letter) {
            "A" -> buttonIsClickList[0] = true
            "B" -> buttonIsClickList[1] = true
            "C" -> buttonIsClickList[2] = true
            "D" -> buttonIsClickList[3] = true
            "E" -> buttonIsClickList[4] = true
            "F" -> buttonIsClickList[5] = true
            "G" -> buttonIsClickList[6] = true
            "H" -> buttonIsClickList[7] = true
            "I" -> buttonIsClickList[8] = true
            "J" -> buttonIsClickList[9] = true
            "K" -> buttonIsClickList[10] = true
            "L" -> buttonIsClickList[11] = true
            "M" -> buttonIsClickList[12] = true
            "N" -> buttonIsClickList[13] = true
            "O" -> buttonIsClickList[14] = true
            "P" -> buttonIsClickList[15] = true
            "Q" -> buttonIsClickList[16] = true
            "R" -> buttonIsClickList[17] = true
            "S" -> buttonIsClickList[18] = true
            "T" -> buttonIsClickList[19] = true
            "U" -> buttonIsClickList[20] = true
            "V" -> buttonIsClickList[21] = true
            "W" -> buttonIsClickList[22] = true
            "X" -> buttonIsClickList[23] = true
            "Y" -> buttonIsClickList[24] = true
            "Z" -> buttonIsClickList[25] = true
            "Æ" -> buttonIsClickList[26] = true
            "Ø" -> buttonIsClickList[27] = true
            "Å" -> buttonIsClickList[28] = true
            }
        }
    fun getIsClicked(letter: String): Boolean {
        when (letter) {
            "A" -> return buttonIsClickList[0]
            "B" -> return buttonIsClickList[1]
            "C" -> return buttonIsClickList[2]
            "D" -> return buttonIsClickList[3]
            "E" -> return buttonIsClickList[4]
            "F" -> return buttonIsClickList[5]
            "G" -> return buttonIsClickList[6]
            "H" -> return buttonIsClickList[7]
            "I" -> return buttonIsClickList[8]
            "J" -> return buttonIsClickList[9]
            "K" -> return buttonIsClickList[10]
            "L" -> return buttonIsClickList[11]
            "M" -> return buttonIsClickList[12]
            "N" -> return buttonIsClickList[13]
            "O" -> return buttonIsClickList[14]
            "P" -> return buttonIsClickList[15]
            "Q" -> return buttonIsClickList[16]
            "R" -> return buttonIsClickList[17]
            "S" -> return buttonIsClickList[18]
            "T" -> return buttonIsClickList[19]
            "U" -> return buttonIsClickList[20]
            "V" -> return buttonIsClickList[21]
            "W" -> return buttonIsClickList[22]
            "X" -> return buttonIsClickList[23]
            "Y" -> return buttonIsClickList[24]
            "Z" -> return buttonIsClickList[25]
            "Æ" -> return buttonIsClickList[26]
            "Ø" -> return buttonIsClickList[27]
            "Å" -> return buttonIsClickList[28]
            else ->
                return false
            }
        }
    }
