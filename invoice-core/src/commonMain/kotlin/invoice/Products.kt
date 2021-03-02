package invoice

import cart.Item
import kotlinx.serialization.Serializable

@Serializable
data class Products(
    val items: List<Item>
) {
    val subTotal get() = items.sumOf { it.subTotal }
    val discountTotal get() = items.sumOf { it.discountTotal }
    val grandTotal get() = items.sumOf { it.grandTotal }
}
