package invoice

import kotlinx.serialization.Serializable

@Serializable
data class Aggregate(
    val positives: List<LineItem> = listOf(),
    val negatives: List<LineItem> = listOf()
) {

    @Serializable
    data class LineItem(
        val details: String,
        val amount: Long
    )

    val total get() = positives.sumOf { it.amount } - negatives.sumOf { it.amount }
}