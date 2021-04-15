package invoice

fun Sender.toCreator() = Creator(uid = uid, name = name)