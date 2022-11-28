package com.example.lykkehjulet.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.random.Random

class LykkehjulGameData() {
    var hasWheelBeenSpined by mutableStateOf(false)
    var pointTotal by mutableStateOf(0)
    var wheelPlacement by mutableStateOf("")
    var wheelText by mutableStateOf("")
    var alert by mutableStateOf("")
    var currentPoint by mutableStateOf(0)
    var lifeTotal by mutableStateOf(3)
    var keyBoard by mutableStateOf("consonant")
    var buttonIsClickList by mutableStateOf(mutableStateListOf(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false))
    var word = randomWord()
    var hashWord by mutableStateOf(wordReplaceWithHash(word))
    var buyLetter by mutableStateOf(false)
    var gameRunning by mutableStateOf(true)
    var gameWon by mutableStateOf(false)
    var wordGuess by mutableStateOf("")

    private fun wordReplaceWithHash(word: String): String {
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

    private fun randomWord(): String {
        val words = listOf("Hej jeg hedder Christoffer", "Jeg er meget sulten", "Hej mor jeg er far")
        val randomIndex = Random.nextInt(words.size)
        return words[randomIndex]
    }
}