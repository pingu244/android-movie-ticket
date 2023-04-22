package com.example.domain.policy

import java.time.LocalDateTime

interface DiscountPolicy {

    fun discountPrice(price: Int): Int
    fun checkPolicy(date: LocalDateTime): Boolean
}
