package com.intive.hangman.engine

import org.junit.Assert.*
import org.junit.Test

class GameTest {

    val hangman = Game(password = "microwave", maxWrongAnswers = 20)

    @Test
    fun `new game has 0 wrong answers`() {
        assertEquals(0, hangman.wrongAnswers)
    }

    @Test
    fun `new game has all letters dashed`() {
        assertEquals("_________", hangman.dashedPassword)
    }

    @Test
    fun `correct letter suggested `() {
        val contains = hangman.suggestLetter('A')

        assertTrue(contains)
        assertEquals(0, hangman.wrongAnswers)
    }

    @Test
    fun `wrong letter suggested`() {
        val contains = hangman.suggestLetter('Z')

        assertFalse(contains)
        assertEquals(1, hangman.wrongAnswers)
    }

    @Test
    fun `correct letter suggested should apear in dashedWord`() {
        val contains = hangman.suggestLetter('A')
        val dashed = hangman.dashedPassword
        assertEquals ("______A__", dashed)
    }

    @Test
    fun `wrong range test`() {
        val charRange = 'A'..'z'
        val wrongLettersRange = charRange.filterNot { c -> "microwave".contains(c, true)}

        for (c in wrongLettersRange) {
            assertFalse(hangman.suggestLetter(c))
        }
    }

    @Test
    fun `correct letter range test`() {
        val charRange = 'A'..'z'
        val correctLettersRange = charRange.filter { c -> "microwave".contains(c, true)}

        for (c in correctLettersRange) {
            assertTrue(hangman.suggestLetter(c))
        }
    }

}