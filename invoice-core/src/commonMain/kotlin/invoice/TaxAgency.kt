package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.jvm.JvmField

@JsExport
@Serializable
class TaxAgency(
    val name: String
) {
    companion object {
        @JvmField
        val GENERIC = TaxAgency("Generic Tax Agency")
    }
}