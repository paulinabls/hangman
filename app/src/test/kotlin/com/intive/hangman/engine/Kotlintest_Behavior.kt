package com.intive.hangman.engine

import com.intive.hangman.TextUtils
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.BehaviorSpec

class Kotlintest_Behavior : BehaviorSpec({
    val password = "microwave"

    Given("new game with password: $password") {
        val game = Game(password)

        When("created") {
            Then("has 0 wrong answers") {
                game.wrongAnswers shouldEqual 0
            }

            Then("has all letters dashed") {
                game.dashedPassword shouldEqual "-".repeat(password.length)
            }
        }

        When("correct letter suggested") {
            for (c in password) {
                Then("returns true for letter $c") {
                    game.suggestLetter(c) shouldEqual true
                }
            }
        }

        When("any wrong letter suggested") {
            val alphabetRangeNotIn = TextUtils.createAlphabetRangeNotIn(password)

            for (c in alphabetRangeNotIn) {
                Then("should return false for letter $c") {
                    game.suggestLetter(c) shouldEqual false
                }
            }
        }
    }
})
