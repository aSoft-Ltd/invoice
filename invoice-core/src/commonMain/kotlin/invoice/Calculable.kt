package invoice

interface Calculable {
    val costBeforeDiscount: Long
    val discount: Long
    val taxAmount: Long
    val costAfterDiscount: Long get() = costBeforeDiscount - discount
    val costBeforeTax: Long get() = costAfterDiscount
    val costAfterTax: Long get() = costBeforeTax + taxAmount
}