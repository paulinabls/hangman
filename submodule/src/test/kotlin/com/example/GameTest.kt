package com.example

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class GameTest : Spek({
    describe("a game") {
        val hangman = Game(password = "microwave", maxWrongAnswers = 20)

        on("freshly created") {
            it("has 0 wrong answers") {
                assertEquals(0, hangman.wrongAnswers)
            }

            it("has all letters dashed") {
                assertEquals("_________", hangman.dashedPassword)
            }
        }

        on("correct letter suggested") {
            val contains = hangman.suggestLetter('A')
            it("returns true") {
                assertTrue(contains)
            }

            it("number of wrong answers did not increase") {
                assertEquals(0, hangman.wrongAnswers)
            }
        }

    }
})