sealed class Expr {
    data class Number(val value: Double) :Expr()
    data class  Add(val left: Expr, val right: Expr) : Expr()
    data class  Subtract(val left: Expr, val right: Expr) : Expr()
    data class  Multiply(val left: Expr, val right: Expr) : Expr()
    data class  Divide(val left: Expr, val right: Expr) : Expr()

}

fun eval(expr: Expr): Double = when (expr) {
    is Expr.Number -> expr.value
    is Expr.Add -> eval(expr.left) + eval(expr.right)
    is Expr.Subtract -> eval(expr.left) - eval(expr.right)
    is Expr.Multiply -> eval(expr.left) * eval(expr.right)
    is Expr.Divide -> eval(expr.left) - eval(expr.right)
}