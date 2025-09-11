fun main() {
    println("Well come to expression evaluator")

    while (true) {
    println("enter the expression:")
        val input = readLine() ?: break
        if (input.lowercase() == "exit") break

        try {
            val tokens = input.split(" ").filter { it.isNotBlank() }
            val expr = parse(tokens)
            val result = eval(expr)
            println("Result: $result")
        } catch (e: Exception) {
            println("❌Error: ${e.message}")
        }
    }
}