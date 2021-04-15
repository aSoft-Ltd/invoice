package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Invoice(
    val uid: String,
    val data: InvoiceData,
    val logs: List<Status>
) {
    constructor(uid: String, data: InvoiceData) : this(uid, data, listOf(data.created))
}