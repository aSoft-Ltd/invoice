package invoice

import kotlinx.serialization.Serializable

@Serializable
data class InvoiceData(
    val sender: Sender,
    val receiver: Receiver,
    val currency: String,
    val created: Status.Created,
    val dueOn: Long,
    val products: Products = Products(items = listOf()),
    val services: Services = Services(items = listOf()),
    val tasks: Tasks = Tasks(items = listOf()),
    val aggregate: Aggregate = Aggregate()
) {
    constructor(
        sender: Sender,
        receiver: Receiver,
        currency: String,
        dueOn: Long,
        products: Products = Products(items = listOf()),
        services: Services = Services(items = listOf()),
        tasks: Tasks = Tasks(items = listOf()),
        aggregate: Aggregate = Aggregate()
    ) : this(
        sender,
        receiver,
        currency,
        Status.Created(by = sender.toCreator()),
        dueOn,
        products,
        services,
        tasks,
        aggregate
    )
}