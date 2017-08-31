package com.intive.hangman.engine

import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.FeatureSpec

class Kotlintest_Feature : FeatureSpec({
    val game = Game("microwave")

    feature("letter verification") {
        scenario("correct letter suggested") {
            game.suggestLetter('a') shouldEqual true
        }

        scenario("wrong letter suggested") {
            game.suggestLetter('b') shouldEqual false
        }
    }
})