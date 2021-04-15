package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Creator(
    val uid: String,
    val name: String
)