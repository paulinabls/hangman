package com.intive.hangman.engine

import com.intive.hangman.TextUtils
import com.winterbe.expekt.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.BehaviorSpec

class KotlintestGameTest_BehaviorSpec : BehaviorSpec() {
    init {
        val password = "microwave"
        //password = Gen.string().nextPrintableString(10)  <- generator

        Given("new game with password: $password") {
            val game = Game(password = password, maxWrongAnswers = 20)

            When("created") {
                Then("has 0 wrong answers") {
                    game.wrongAnswers.shouldEqual(0)
                }

                Then("has all letters dashed") {
                    val length = password.length
                    game.dashedPassword.should.match(Regex("_{$length}")) //expekt
                }
            }

            When("correct letter suggested") {
                for (c in password) {
                    Then("returns true for letter $c") {
                        game.suggestLetter(c).shouldBe(true)
                    }

                    Then("number of wrong answers did not increase") {
                        game.wrongAnswers.shouldEqual(0)
                    }
                }
            }

            When("any wrong letter suggested") {
                val alphabetRangeNotIn = TextUtils.createAlphabetRangeNotIn(password)

                for (c in alphabetRangeNotIn) {
                    Then("should return false for letter $c") {
                        game.suggestLetter(c).should.be.`false`
                    }
                }
            }
        }
    }
}