package io.devpass.creditcard.data.entities

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

data class CreditCardInvoiceEntity(
    val id: String,
    val credit_card: String,
    val month: Int,
    val year: Int,
    val value: Double,
    @CreationTimestamp
    val created_at: LocalDateTime = LocalDateTime.now(),
    @CreationTimestamp
    val pait_at: LocalDateTime? = LocalDateTime.now()
)