import java.util.Stack

private const val LEFT = ')'
private const val RIGHT = '('
private const val IS_NOT_VPS = "NO"
private const val IS_VPS = "YES"

fun main(args: Array<String>) {
    val lines = readln().toInt()

    val input = (0 until lines).map {
        readln()
    }

    val result = input
        .map { validateVPS(it) }

    val stringBuilder = java.lang.StringBuilder()

    result.forEach {
        stringBuilder.append("$it\n")
    }

    println(stringBuilder)
}

private fun validateVPS(string: String): String {
    val stack = Stack<Char>()

    string.forEach {
        if (it == RIGHT) {
            stack.push(it)
        } else {
            if (stack.isEmpty()) return IS_NOT_VPS

            stack.pop()
        }
    }

    if (stack.isNotEmpty()) return IS_NOT_VPS

    return IS_VPS
}