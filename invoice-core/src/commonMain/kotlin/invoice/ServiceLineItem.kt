package invoice

import kotlinx.serialization.Serializable

@Serializable
data class ServiceLineItem(
    val uid: String,
    val details: String,
    val logo: String?,
    val amount: Long,
    val discount: Long
) {
    val total get() = amount - discount
}