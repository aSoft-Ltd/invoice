package invoice

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
sealed class Status {
    @Serializable
    data class Created(
        val on: LocalDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date,
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