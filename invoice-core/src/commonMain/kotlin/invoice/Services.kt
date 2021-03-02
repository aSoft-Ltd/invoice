package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Services(
    val items: List<LineItem>,
) {
    @Serializable
    data class LineItem(
        val uid: String,
        val details: String,
        val logo: String?,
        val amount: Long,
        val discount: Long
    ) {
        val total get() = amount - discount
    }

    val subTotal get() = items.sumOf { it.amount }
    val discountTotal get() = items.sumOf { it.discount }
    val grandTotal get() = items.sumOf { it.total }
}