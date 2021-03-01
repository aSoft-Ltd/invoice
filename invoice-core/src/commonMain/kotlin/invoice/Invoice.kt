package invoice

import cart.*
import kotlinx.serialization.Serializable

@Serializable
/**
 * @param cart The cart itself
 * @param positiveLineItem Increase the total price of the cart (i.e. tax)
 * @param negativeLineItem Decrease the total price of the cart (i.e. discounts)
 */
data class Invoice(
    val uid: String,
    val products: Products = Products(items = listOf()),
    val services: Services = Services(items = listOf()),
    val tasks: Tasks = Tasks(items = listOf()),
    val aggregate: Aggregate = Aggregate()
) {

    @Serializable
    data class Products(
        val items: List<CartItem>
    ) {
        val subTotal get() = items.sumOf { it.subTotal }
        val discountTotal get() = items.sumOf { it.discountTotal }
        val grandTotal get() = items.sumOf { it.grandTotal }
    }

    @Serializable
    data class Services(
        val items: List<ServiceLineItem>,
    ) {
        val subTotal get() = items.sumOf { it.amount }
        val discountTotal get() = items.sumOf { it.discount }
        val grandTotal get() = items.sumOf { it.total }
    }

    @Serializable
    data class Tasks(
        val items: List<TaskLineItem>
    ) {
        val subTotal get() = items.sumOf { it.subTotal }
        val discountTotal get() = items.sumOf { it.discountTotal }
        val grandTotal get() = items.sumOf { it.grandTotal }
    }

    @Serializable
    data class Aggregate(
        val positives: List<AggregateLineItem> = listOf(),
        val negatives: List<AggregateLineItem> = listOf()
    ) {
        val total get() = positives.sumOf { it.amount } - negatives.sumOf { it.amount }
    }

    val subTotal get() = products.grandTotal + services.grandTotal + tasks.grandTotal

    val grandTotal get() = subTotal + aggregate.total
}