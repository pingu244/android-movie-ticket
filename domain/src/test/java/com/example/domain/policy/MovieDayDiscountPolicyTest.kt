package com.example.domain.policy

import junit.framework.TestCase
import org.junit.Test
import java.time.LocalDateTime

class MovieDayDiscountPolicyTest {
    @Test
    fun `10일이라면 무비데이다`() {
        val date = LocalDateTime.of(2023, 4, 10, 15, 10)
        TestCase.assertTrue(MovieDayDiscountPolicy().checkPolicy(date))
    }

    @Test
    fun `20일이라면 무비데이다`() {
        val date = LocalDateTime.of(2023, 4, 20, 15, 10)
        TestCase.assertTrue(MovieDayDiscountPolicy().checkPolicy(date))
    }

    @Test
    fun `30일이라면 무비데이다`() {
        val date = LocalDateTime.of(2023, 4, 30, 15, 10)
        TestCase.assertTrue(MovieDayDiscountPolicy().checkPolicy(date))
    }

    @Test
    fun `티켓 값이 13000원이면, 무비데이 할인 정책이 적용하여 11700원을 반환한다`() {
        val price = 13000
        TestCase.assertEquals(MovieDayDiscountPolicy().discountPrice(price), 11700)
    }
}
