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
    val uid: String? = null,
    val currency: String,
    val products: Products = Products(items = listOf()),
    val services: Services = Services(items = listOf()),
    val tasks: Tasks = Tasks(items = listOf()),
    val aggregate: Aggregate = Aggregate()
) {
    val subTotal get() = products.grandTotal + services.grandTotal + tasks.grandTotal
    val grandTotal get() = subTotal + aggregate.total
}