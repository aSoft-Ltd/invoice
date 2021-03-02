package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Tasks(
    val items: List<LineItem>
) {
    @Serializable
    data class LineItem(
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

    val subTotal get() = items.sumOf { it.subTotal }
    val discountTotal get() = items.sumOf { it.discountTotal }
    val grandTotal get() = items.sumOf { it.grandTotal }
}
