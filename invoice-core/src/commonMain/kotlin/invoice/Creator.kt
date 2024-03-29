package invoice

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Creator(
    val uid: String,
    val name: String
)