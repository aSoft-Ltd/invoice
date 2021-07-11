package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.jvm.JvmField

@JsExport
@Serializable
data class Tax(
    val name: String,
    /**
     * must be between 0 and 100
     */
    val rate: Int,
    val agency: TaxAgency
) {
    init {
        require(rate in 0..100) { "rate must be between 0 and 100 " }
    }

    companion object {
        @JvmField
        val GENERIC_ZERO = Tax("ZERO", 0, TaxAgency.GENERIC)
    }
}