package invoice

import kotlinx.serialization.Serializable

@Serializable
data class AggregateLineItem(
    val details: String,
    val amount: Long
)