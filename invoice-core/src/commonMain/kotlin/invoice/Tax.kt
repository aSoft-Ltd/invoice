package invoice

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmField

@Serializable
data class Tax(
    val name: String,
    /**
     * must be between 0 and 100
     */
    val rate: Int
) {
    init {
        require(rate in 0..100) { "rate must be between 0 and 100 " }
    }

    companion object {
        @JvmField
        val ZERO = Tax("ZERO", 0)
    }
}