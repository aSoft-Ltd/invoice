package invoice

import kotlinx.serialization.Serializable

@Serializable
data class TaskLineItem(
    val uid: String,
    val details: String,
    val rate: Long,
    val unit: String,
    val quantity: Int,
    val discount: Long
) {
    val subTotal get() = rate * quantity
    val discountTotal get() = discount * quantity
    val grandTotal get() = subTotal - discountTotal
}