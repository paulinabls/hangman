package com.example

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class GameTest : Spek({
    given("playing hangman") {
        val hangman = Game(password = "microwave", maxWrongAnswers = 20)

        afterEachTest{
            hangman.reset()
        }

        on("newly created game") {
            //            val hangman = Game(password = "microwave", maxWrongAnswers = 20)
            it("has 0 wrong answers") {
                Assert.assertEquals(0, hangman.wrongAnswers)
            }

            it("has all letters dashed") {
                Assert.assertEquals("_________", hangman.dashedPassword)
            }
        }

        on("correct letter suggested") {
            //            val hangman = Game(password = "microwave", maxWrongAnswers = 20)
            val contains = hangman.suggestLetter('A')
            it("returns true") {
                assertTrue(contains)
            }

            it("number of wrong answers did not increase") {
                assertEquals(0, hangman.wrongAnswers)
            }
        }

        on("wrong letter suggested "){
            //            val hangman = Game(password = "microwave", maxWrongAnswers = 20)
            val contains = hangman.suggestLetter('Z')

            it("returns false") {
                assertFalse(contains)
            }

            it ("increases number of wrong answers") {
                assertEquals(1, hangman.wrongAnswers)
            }
        }
    }
})