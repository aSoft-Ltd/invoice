package invoice

import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

@Serializable
sealed class Status {
    @Serializable
    data class Created(
        val on: Long = Clock.System.now().toEpochMilliseconds(),
        val by: Creator
    ) : Status()

    @Serializable
    sealed class Paid(
        val amount: Long,
        val left: Long
    ) : Status()

    @Serializable
    object Completed : Status()
}