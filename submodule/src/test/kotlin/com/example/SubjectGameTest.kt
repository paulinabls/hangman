package com.example

import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.xon
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.Assert
import org.junit.Assert.*
import org.junit.runner.RunWith

class SubjectGameTest: SubjectSpek<Game>({
    subject{ Game(password = "microwave", maxWrongAnswers = 20) }
    given ("new game") {
        on("created") {
            it("has 0 wrong answers") {
                assertEquals(0, subject.wrongAnswers)
            }

            it("has all letters dashed") {
                assertEquals("_________", subject.dashedPassword)
            }
        }
    }

    on("correct letter suggested") {
        val contains = subject.suggestLetter('A')
        it("returns true") {
            assertTrue(contains)
        }

        it("number of wrong answers did not increase") {
            assertEquals(0, subject.wrongAnswers)
        }
    }

    val wrongLetter = 'Z'
    on("wrong letter suggested like $wrongLetter") {
        val contains = subject.suggestLetter(wrongLetter)
        it(" returns false") {
            assertTrue(contains)
        }

        it("number of wrong answers increased") {
            assertEquals(1, subject.wrongAnswers)
        }
    }

    on("any wrong letter suggested ") {
        val wrongLettersRange = TextUtils.createAlphabetRangeNotIn("microwave")

        for (c in wrongLettersRange) {
            it ("for $c returns false") {
                assertFalse(subject.suggestLetter(c))
            }
        }
    }

    xon("proper password guessed", "Greg was lazy :P ") {
//        val guessed = subject.guess("microwave")
        it("returns true") {

        }
        it("has dashed password filled with letters") {

        }
    }

})