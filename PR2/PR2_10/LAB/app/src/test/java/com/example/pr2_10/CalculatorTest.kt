package com.example.pr2_10

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class CalculatorTest {
    private var calculator: Calculator? = null
    @Before
    fun setUp() {
        calculator = Calculator()
    }
    @Test
    fun addition_isCorrect() {
        assertEquals(4, calculator?.add(2,2))
    }

    @Test
    fun subtract_isCorrect() {
        assertEquals(4, calculator?.subtract(8,4))
    }

    @Test
    fun multiply_isCorrect() {
        assertEquals(4, calculator?.multiply(2,2))
    }

    @Test
    fun divide_isCorrect() {
        assertEquals(4, calculator?.divide(24,6))
    }

    @Test
    fun divide_by_zero_isCorrect() {
        assertEquals(0, calculator?.divide(4,0))
    }

    @Test
    fun operations_isCorrect() {
        assertEquals(4, calculator?.add(2,2))
        assertEquals(4, calculator?.subtract(8,4))
        assertEquals(4, calculator?.multiply(2,2))
        assertEquals(4, calculator?.divide(24,6))
    }

    @After
    fun tearDown() {
        calculator = null
    }

}