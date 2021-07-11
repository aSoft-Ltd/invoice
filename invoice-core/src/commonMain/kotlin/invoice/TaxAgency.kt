package invoice

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

@Serializable
class TaxAgency(
    val name: String
) {
    companion object {
        @JvmField
        val GENERIC = TaxAgency("Generic Tax Agency")
    }
}