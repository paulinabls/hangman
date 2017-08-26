package com.intive.hangman.engine

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith


@RunWith(JUnitPlatform::class)
object SpekGameTest : Spek({
    describe("a game") {
        val hangman = Game(password = "microwave", maxWrongAnswers = 20)

        on("freshly created") {
            it("has 0 wrong answers") {
                assertEquals(1, hangman.wrongAnswers)
            }

            it("has all letters dashed") {
                assertEquals("_________", hangman.dashedPassword)
            }
        }

        on("correct letter suggested") {
            val contains = hangman.suggestLetter('A')
            it("returns true") {
                Assert.assertTrue(contains)
            }

            it("number of wrong answers did not increase") {
                assertEquals(0, hangman.wrongAnswers)
            }
        }

    }
})