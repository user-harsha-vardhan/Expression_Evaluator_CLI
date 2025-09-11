sealed class Expr {
    data class Number(val value: Double) : Expr()
    data class Add(val left: Expr, val right: Expr) : Expr()
    data class Subtract(val left: Expr, val right: Expr) : Expr()
    data class Multiply(val left: Expr, val right: Expr) : Expr()
    data class Divide(val left: Expr, val right: Expr) : Expr()

}

fun eval(expr: Expr): Double = when (expr) {
    is Expr.Number -> expr.value
    is Expr.Add -> eval(expr.left) + eval(expr.right)
    is Expr.Subtract -> eval(expr.left) - eval(expr.right)
    is Expr.Multiply -> eval(expr.left) * eval(expr.right)
    is Expr.Divide -> eval(expr.left) / eval(expr.right)
}

fun parse(tokens: List<String>): Expr {
    if (tokens.size == 1) return Expr.Number(tokens[0].toDouble())

    var index = tokens.indexOfFirst { it == "+" || it == "-" }
    if (index != -1) {
        val left = parse(tokens.subList(0, index))
        val right = parse(tokens.subList(index + 1, tokens.size))
        return if (tokens[index] == "+") Expr.Add(left, right) else Expr.Subtract(left, right)
    }
    index = tokens.indexOfFirst{ it == "*" || it == "/" }
    if (index != -1) {
        val left = parse(tokens.subList(0, index))
        val right = parse(tokens.subList(index + 1, tokens.size))
        return if (tokens[index] == "*" ) Expr.Multiply(left, right) else Expr.Divide(left, right)
    }
    throw IllegalArgumentException ("Invalid expression: $tokens")
}