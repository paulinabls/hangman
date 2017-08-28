package com.example

class Game(val password: String, val maxWrongAnswers: Int) {

    var wrongAnswers: Int = 0
        private set
    private val dashedWord: StringBuffer = StringBuffer(password.length)

    val dashedPassword : String get() {
        System.err.println("dashedPassword get " + dashedWord)
        return dashedWord.toString()
    }

    init {
        appendDashes()
    }

    private fun appendDashes() {
        password.forEach { dashedWord.append('_') }
    }

    fun reset() {
        System.out.println("\n reset")
        dashedWord.delete(0,dashedWord.length)
        appendDashes()
        wrongAnswers = 0
    }

    fun suggestLetter(letter: Char): Boolean {
        val contains = password.contains(letter, true)
        if (contains) {
            refreshDashedWord(letter.toUpperCase())
        } else {
            wrongAnswers++
        }
        System.err.println("suggestLetter $letter")
        return contains
    }

    private fun refreshDashedWord(guessedLetter: Char) {
        password.forEachIndexed { index, char ->
            if (char.equals(guessedLetter, true) ) dashedWord.setCharAt(index, guessedLetter)
        }
    }

}