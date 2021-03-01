package cart

val Collection<CartInvoiceLineItem>.total get() = sumOf { it.amount }