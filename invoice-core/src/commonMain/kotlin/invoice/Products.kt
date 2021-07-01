package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@Serializable
data class Products(
    val items: List<LineItem>
) {

    @JsName("fromArray")
    constructor(vararg items: LineItem) : this(items.toList())

    val subTotal get() = items.sumOf { it.subTotal }
    val discountTotal get() = items.sumOf { it.discountTotal }
    val grandTotal get() = items.sumOf { it.grandTotal }

    @Serializable
    data class LineItem(
        val uid: String,
        val name: String,
        val price: Long,
        val quantity: Int,
        val images: List<String>,
        val discount: Long
    ) {
        /**
         * Sum of price for all the quantities
         */
        val subTotal: Long get() = price * quantity

        /**
         * Sum of discount for all the quantities
         */
        val discountTotal: Long get() = discount * quantity

        /**
         * Total with discount taken into consideration
         */
        val grandTotal: Long get() = subTotal - discountTotal
    }
}
