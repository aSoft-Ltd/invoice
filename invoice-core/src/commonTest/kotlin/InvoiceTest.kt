import invoice.*
import kash.Currency
import kotlinx.datetime.LocalDate
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class InvoiceTest {
    @Test
    fun should_serialize() {
        val address = Address.Description("Test Address");
        val invoice = Invoice(
            uid = "<unset>",
            header = Invoice.Header(
                sender = Sender("<unset>", "Test Sender", address),
                receiver = Receiver("<unset>", "Receiver", address),
                currency = Currency.TZS,
                createdOn = LocalDate(2021, 1, 1)
            ),
            body = Invoice.Body(
                LineItem.Product("<unset>", "Keyboard", 2000000, 1),
                LineItem.Task("<unset>", "Computer Maintenace", 10000000, "man-days", 2)
            )
        )
        println(Json.encodeToString(invoice))
    }
}