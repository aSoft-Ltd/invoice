package cart

import tz.co.asoft.expect
import tz.co.asoft.toBe
import kotlin.test.Test

class CartInvoiceTest {
    val cart = Cart(
        uid = "cart-1",
        CartItem(
            uid = "item-1",
            name = "R.B",
            quantity = 1,
            price = 2000,
            images = listOf(),
            discount = 0
        ),
        CartItem(
            uid = "item-2",
            name = "Soda",
            quantity = 1,
            price = 600,
            images = listOf(),
            discount = 0
        ),
        CartItem(
            uid = "item-3",
            name = "Banana",
            quantity = 2,
            price = 200,
            images = listOf(),
            discount = 0
        )
    )

    @Test
    fun should_have_a_subtotal_for_all_cart_items() {
        val invoice = CartInvoice(
            cart = cart,
            positiveLineItem = listOf(
                CartInvoiceLineItem(
                    details = "delivery fee",
                    amount = 500
                ),
                CartInvoiceLineItem(
                    details = "tax",
                    amount = 250
                )
            ),
            negativeLineItem = listOf(
                CartInvoiceLineItem(
                    details = "discount",
                    amount = 1000
                )
            )
        )
        expect(invoice.subTotal).toBe(3000)
        expect(invoice.positives).toBe(750)
        expect(invoice.negatives).toBe(1000)
        expect(invoice.total).toBe(2750)
    }
}