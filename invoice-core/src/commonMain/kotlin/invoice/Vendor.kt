package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
open class Vendor(
    val name: String
) {
    companion object {
        val GENERIC = Vendor("Generic Vendor")
    }
}