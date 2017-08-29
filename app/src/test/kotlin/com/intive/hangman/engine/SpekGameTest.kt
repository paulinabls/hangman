package com.intive.hangman.engine

import com.intive.hangman.TextUtils
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert
import org.junit.Assert.assertEquals
import kotlin.test.assertFalse

//@RunWith(JUnitPlatform::class)
class SpekGameTest : Spek({
    describe("a game") {
        given("newly created game") {
            val hangman = Game(password = "microwave", maxWrongAnswers = 20)
            it("has 0 wrong answers") {
                assertEquals(0, hangman.wrongAnswers)
            }

            it("has all letters dashed") {
                assertEquals("_________", hangman.dashedPassword)
            }
        }

        val hangman = Game(password = "microwave", maxWrongAnswers = 20)

        on("correct letter suggested") {
            val contains = hangman.suggestLetter('A')
            it("returns true") {
                Assert.assertTrue(contains)
            }

            it("number of wrong answers did not increase") {
                assertEquals(0, hangman.wrongAnswers)
            }
        }

        on("any wrong letter suggested ") {
            val wrongLettersRange = TextUtils.createAlphabetRangeNotIn("microwave")

            for (c in wrongLettersRange) {
                it("for $c returns false") {
                    assertFalse(hangman.suggestLetter(c))
                }
            }
        }

    }
})