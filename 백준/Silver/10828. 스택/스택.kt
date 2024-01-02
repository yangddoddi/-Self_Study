import java.util.Stack

fun main(args: Array<String>) {
    val n = readln().toInt()
    val stack = Stack<Int>()

    val commands = (0 until n)
        .map {
            readln()
        }

    val result: MutableList<Int> = mutableListOf()
    for (i in commands.indices) {
        val splitCommand = commands[i].split(" ")
        val commandPrefix = splitCommand[0]
        val commandPostfix = splitCommand.getOrNull(1)


        when (commandPrefix) {
            COMMAND.PUSH.prefix -> {
                val number = commandPostfix?.toInt() ?: throw RuntimeException()

                stack.push(number)
            }
            COMMAND.POP.prefix -> {
                result.add(stack.popOrNegativeNumber())
            }
            COMMAND.SIZE.prefix -> {
                result.add(stack.size)
            }
            COMMAND.EMPTY.prefix -> {
                result.add(stack.emptyReturnInt())
            }
            COMMAND.TOP.prefix -> {
                result.add(stack.topOrNegativeNumber())
            }
        }
    }

    val stringBuilder = java.lang.StringBuilder()

    result.forEach {
        stringBuilder.append("$it\n")
    }

    println(stringBuilder)
}

enum class COMMAND(
    val prefix: String
) {
    PUSH("push"),
    POP("pop"),
    SIZE("size"),
    EMPTY("empty"),
    TOP("top")
}

private fun Stack<Int>.popOrNegativeNumber(): Int {
    if (this.size == 0) return -1

    return this.pop()
}

private fun Stack<Int>.topOrNegativeNumber(): Int {
    if (this.size == 0) return -1

    return this.peek()
}

private fun Stack<Int>.emptyReturnInt(): Int {
    if (this.isEmpty()) return 1

    return 0
}