import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    // 보드는 정사각형
    val boardSize = readln().toInt()
    // 사과 개수
    val appleCount = readln().toInt()
    // 사과 위치를 담은 배열
    val applePosition: ArrayList<ApplePosition> = ArrayList()

    repeat(appleCount) {
        val (row, column) = readln()
            .split(" ")
            .map { it.toInt() }

        applePosition.add(ApplePosition(row, column))
    }

    // 방향 변환 횟수
    val moveCount = readln().toInt()
    // 방향 변환 정보
    val snakePositionMap: HashMap<Int, String> = HashMap()

    repeat(moveCount) {
        readln()
            .split(" ")
            .let {
                val second = it[0].toInt()
                val direction = it[1]

                snakePositionMap[second] = direction
            }
    }

    val board: Array<Array<String>> = Array(boardSize + 1) { Array(boardSize + 1) { "" } }

    for (i in applePosition.indices) {
        val (row, column) = applePosition[i]

        board[row][column] = "Apple"
    }

    println(
        startGame(
            snakePositionMap,
            board
        )
    )
}

fun startGame(
    snakePositionMap: HashMap<Int, String>,
    board: Array<Array<String>>
): Int {
    var count = 0
    val snake = Snake(1, 1, Direction.RIGHT)
    val tailQueue: Queue<Pair<Int, Int>> = LinkedList()

    board[snake.row][snake.column] = "S"

    while (true) {
        count++

        tailQueue.add(Pair(snake.row, snake.column))

        when (snake.direction) {
            Direction.RIGHT -> snake.column += 1
            Direction.DOWN -> snake.row += 1
            Direction.LEFT -> snake.column -= 1
            Direction.UP -> snake.row -= 1
        }

        if (snake.row <= 0 || snake.row > board.size-1) {
            return count
        }

        if (snake.column <= 0 || snake.column > board.size-1) {
            return count
        }

        if (board[snake.row][snake.column] == "S") {
            return count
        }

        if (board[snake.row][snake.column] != "Apple") {
            val lastTailPosition = tailQueue.poll()
            board[lastTailPosition.first][lastTailPosition.second] = ""
        }

        board[snake.row][snake.column] = "S"

        if (snakePositionMap.containsKey(count)) {
            if (snakePositionMap[count] == "D") {
                snake.rotateToRight()
            }

            if (snakePositionMap[count] == "L") {
                snake.rotateToLeft()
            }
        }

    }
}

data class Snake(
    var row: Int,
    var column: Int,
    var direction: Direction
) {
    fun rotateToLeft() {
        if (this.direction == Direction.RIGHT) {
            this.direction = Direction.UP
        } else if (this.direction == Direction.UP) {
            this.direction = Direction.LEFT
        } else if (this.direction == Direction.LEFT) {
            this.direction = Direction.DOWN
        } else if (this.direction == Direction.DOWN) {
            this.direction = Direction.RIGHT
        }
    }

    fun rotateToRight() {
        if (this.direction == Direction.RIGHT) {
            this.direction = Direction.DOWN
        } else if (this.direction == Direction.DOWN) {
            this.direction = Direction.LEFT
        } else if (this.direction == Direction.LEFT) {
            this.direction = Direction.UP
        } else if (this.direction == Direction.UP) {
            this.direction = Direction.RIGHT
        }
    }
}

data class ApplePosition(
    val row: Int,
    val column: Int
)

enum class Direction() {
    LEFT,
    RIGHT,
    UP,
    DOWN
}