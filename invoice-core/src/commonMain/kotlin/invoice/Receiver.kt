package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Receiver(
    val uid: String,
    val name: String
)