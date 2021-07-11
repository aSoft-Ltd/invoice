@file:JvmName("SenderUtils")

package invoice

import kotlin.jvm.JvmName

fun Sender.toCreator() = Creator(uid = uid, name = name)