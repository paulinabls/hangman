package com.intive.hangman.engine

class Game(val password: String) {

    val MAX_WRONG_ANSWERS = 9

    var wrongAnswers: Int = 0
        private set
    private val dashedWord: StringBuffer = StringBuffer(password.length)

    val dashedPassword get() = dashedWord.toString()

    init {
        password.forEach {dashedWord.append('_')}
    }
    fun suggestLetter(letter: Char): Boolean {
        val contains = password.contains(letter, true)
        if (contains) {
            refreshDashedWord(letter.toUpperCase())
        } else {
            wrongAnswers++
        }
        return contains
    }

    private fun refreshDashedWord(guessedLetter: Char) {
        password.forEachIndexed { index, char ->
            if (char.equals(guessedLetter, true) ) dashedWord.setCharAt(index, guessedLetter)
        }
    }

}
