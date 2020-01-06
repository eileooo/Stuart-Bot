package core.framework

import java.lang.RuntimeException

fun fail(message: String): Nothing = throw ArgumentException(message)

class ArgumentException(
    var error: String
) : RuntimeException()



