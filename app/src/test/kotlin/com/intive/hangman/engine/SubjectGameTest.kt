package com.intive.hangman.engine

import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.Assert

class SubjectGameTest : SubjectSpek<Game>({
    subject { Game(password = "microwave") }
    given("new game") {
        on("created") {
            it("has 0 wrong answers") {
                Assert.assertEquals(0, subject.wrongAnswers)
            }

            it("has all letters dashed") {
                Assert.assertEquals("_________", subject.dashedPassword)
            }
        }
    }

    on("correct letter suggested") {
        val contains = subject.suggestLetter('A')
        it("returns true") {
            Assert.assertTrue(contains)
        }

        it("number of wrong answers did not increase") {
            Assert.assertEquals(0, subject.wrongAnswers)
        }
    }

})