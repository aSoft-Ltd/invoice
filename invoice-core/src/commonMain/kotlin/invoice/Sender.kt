package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Sender(
    val uid: String,
    val name: String
)