import invoice.*
import invoice.Invoice.Body

object TestUtils {
    const val UNSET = "<unset>"

    @JvmStatic
    fun makeAddress(): Address {
        return Address.Description("Test Address")
    }

    @JvmStatic
    fun makeSender(address: Address): Sender {
        return Sender(UNSET, "Test Sender", address)
    }

    @JvmStatic
    fun makeReceiver(address: Address): Receiver {
        return Receiver(UNSET, "Test Receiver", address)
    }

    @JvmStatic
    @JvmOverloads
    fun makeBody(tax1: Tax = Tax.ZERO, tax2: Tax = tax1): Body {
        return Body(
            LineItem.Product(UNSET, "Test Product 1", 100000, 1, tax1.copy()),
            LineItem.Product(UNSET, "Test Product 2", 200000, 2, tax2.copy()),
            LineItem.Product(UNSET, "Test Product 3", 300000, 3, tax1.copy()),
            LineItem.Product(UNSET, "Test Product 4", 400000, 4, tax2.copy()),
            LineItem.Product(UNSET, "Test Product 5", 500000, 5, tax1.copy())
        )
    }
}
