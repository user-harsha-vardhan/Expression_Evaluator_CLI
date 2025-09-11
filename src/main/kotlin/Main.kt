import java.util.*
import kotlin.math.exp

fun main() {
    println("Welcome to expression evaluator cli \" Type exit to exit \" ")
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Enter the EXP>")
        val input = scanner.nextLine()

        if (input.lowercase() == "exit") {
            println("Sayonara 👋")
            break
        }

        try {
            val result = evaluateExp(input)
            println("= $result")
        } catch (e: Exception) {
            println(" ❌ Error: ${e.message}")
        }

    }
}

fun evaluateExp(expr: String) : Double {
    val tokens = tokenize(expr)
    val postfix = infixToPostfix(tokens)
    return evaluatePostfix(postfix)
}

fun tokenize (expr: String): List<String> {
    val tokens = mutableListOf<String>()
    val number = " "

    for (ch in expr) {
        when {
            ch.isDigit() || ch = '.' -> number += ch
            ch == ' ' -> continue
        }
    }
}