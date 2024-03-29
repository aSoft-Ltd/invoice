package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.jvm.JvmOverloads

@JsExport
@Serializable
data class Receiver @JvmOverloads constructor(
    val uid: String,
    val name: String,
    val address: Address,
    val ref: VendorReference = VendorReference.UNSET
)