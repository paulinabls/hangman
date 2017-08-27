package com.example

class TextUtils {
    companion object {
        fun createAlphabetRangeNotIn(word: String): List<Char> {
            val charRange = 'A'..'z'
            val wrongLettersRange = charRange.filterNot { c -> word.contains(c, true) }
            return wrongLettersRange
        }
    }

}