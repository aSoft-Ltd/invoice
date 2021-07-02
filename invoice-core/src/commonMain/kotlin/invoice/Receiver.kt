package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Receiver(
    val uid: String,
    val name: String,
    val address: Address
)