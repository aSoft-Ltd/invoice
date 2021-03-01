package invoice

val Collection<AggregateLineItem>.total get() = sumOf { it.amount }