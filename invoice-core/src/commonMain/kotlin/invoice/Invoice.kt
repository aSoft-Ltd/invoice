package invoice

import kash.Currency
import kotlinx.datetime.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmOverloads

@JsExport
@Serializable
data class Invoice @JvmOverloads constructor(
    val uid: String,
    val header: Header,
    val body: Body,
    val logs: List<Status> = listOf()
) {
    @Serializable
    data class Header @JvmOverloads constructor(
        val sender: Sender,
        val receiver: Receiver,
        val currency: Currency,
        val createdOn: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date,
        val dueOn: LocalDate = createdOn + DatePeriod(days = 30),
        val vendor: Vendor = Vendor.GENERIC
    )

    @Serializable
    class Body(val items: List<LineItem>) : Calculable {
        @JsName("fromArray")
        constructor(vararg items: LineItem) : this(items.toList())

        override val costBeforeDiscount: Long get() = items.sumOf { it.costBeforeDiscount }

        override val discount: Long get() = items.sumOf { it.discount }

        @Transient
        val taxRates = run {
            val rates = mutableMapOf<Tax, Long>()
            for (item in items) {
                val prev = rates.getOrPut(item.tax) { 0 }
                rates[item.tax] = prev + item.taxAmount
            }
            rates
        }

        override val taxAmount: Long get() = taxRates.values.sum()
    }
}