package invoice

import kash.Currency
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.jvm.JvmOverloads

@JsExport
@Serializable
data class Invoice(
    val uid: String,
    val header: Header,
    val body: Body,
    val logs: List<Status>
) {
    @Serializable
    data class Header @JvmOverloads constructor(
        val sender: Sender,
        val receiver: Receiver,
        val createdOn: LocalDate,
        val dueOn: LocalDate,
        val currency: Currency,
        val vendor: Vendor? = null
    )

    @Serializable
    data class Body(
        val products: Products = Products(),
        val services: Services = Services(),
        val tasks: Tasks = Tasks(),
        val aggregate: Aggregate = Aggregate()
    )
}