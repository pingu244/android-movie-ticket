package com.example.domain

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class DiscountPriceTest {

    @Test
    fun `티켓이 10000원일 때, 할인이 적용되지 않은 티켓 값은 10000원이다`() {
        val discountPrice = DiscountPrice(LocalDateTime.of(2024, 4, 1, 15, 10))
        val expect = 10000

        assertEquals(discountPrice.calculateTotalPrice(10000), expect)
    }

    @Test
    fun `티켓이 10000원일 때, 조조 할인이 적용된 티켓 값은 8000원이다`() {
        val discountPrice = DiscountPrice(LocalDateTime.of(2024, 4, 1, 9, 10))
        val expect = 8000

        assertEquals(discountPrice.calculateTotalPrice(10000), expect)
    }

    @Test
    fun `티켓이 10000원일 때, 무비데이 할인이 적용된 티켓 값은 9000원이다`() {
        val discountPrice = DiscountPrice(LocalDateTime.of(2024, 4, 10, 15, 10))
        val expect = 9000

        assertEquals(discountPrice.calculateTotalPrice(10000), expect)
    }

    @Test
    fun `티켓이 10000원일 때, 무비데이 할인과 야간 할인이 적용된 티켓 값은 7000원이다`() {
        val discountPrice = DiscountPrice(LocalDateTime.of(2024, 4, 10, 21, 10))
        val expect = 7000

        assertEquals(discountPrice.calculateTotalPrice(10000), expect)
    }
}
