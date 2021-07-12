package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.jvm.JvmOverloads

@JsExport
@Serializable
sealed class LineItem : Calculable {
    abstract val tax: Tax

    /**
     * cost of a [LineItem] without discount in mind
     */
    override val taxAmount: Long get() = costBeforeTax * tax.rate / 100

    @Serializable
    data class Product @JvmOverloads constructor(
        val uid: String,
        val name: String,
        val unitPrice: Long,
        val quantity: Int,
        override val tax: Tax = Tax.GENERIC_ZERO,
        val ref: VendorReference = VendorReference.UNSET,
        val unitDiscount: Long = 0,
        val images: List<String> = listOf()
    ) : LineItem() {

        /**
         * Sum of price for all the quantities
         */
        override val costBeforeDiscount: Long get() = subTotal


        val subTotal: Long get() = unitPrice * quantity

        /**
         * Sum of discount for all the quantities
         */
        override val discount: Long get() = unitDiscount * quantity
    }

    @Serializable
    data class Service @JvmOverloads constructor(
        val uid: String,
        val details: String,
        val amount: Long,
        override val tax: Tax = Tax.GENERIC_ZERO,
        val ref: VendorReference = VendorReference.UNSET,
        override val discount: Long = 0,
        val logo: String? = null,
    ) : LineItem() {
        override val costBeforeDiscount get() = amount - discount
    }

    @Serializable
    data class Task @JvmOverloads constructor(
        val uid: String,
        val details: String,
        val unitRate: Long,
        val unit: String,
        val quantity: Int,
        override val tax: Tax = Tax.GENERIC_ZERO,
        val ref: VendorReference = VendorReference.UNSET,
        val unitDiscount: Long = 0
    ) : LineItem() {
        val subTotal get() = unitRate * quantity
        override val costBeforeDiscount: Long = subTotal
        override val discount get() = unitDiscount * quantity
    }

    @Serializable
    data class Generic @JvmOverloads constructor(
        val details: String,
        val amount: Long,
        override val tax: Tax = Tax.GENERIC_ZERO,
        val ref: VendorReference = VendorReference.UNSET,
    ) : LineItem() {
        override val costBeforeDiscount = amount
        override val discount = 0L
    }
}