sealed class Expr {
    data class Number(val value: Double) :Expr()
    data class  Add(val left: Expr, val right: Expr) : Expr()
    data class  Subtract(val left: Expr, val right: Expr) : Expr()
    data class  Multiply(val left: Expr, val right: Expr) : Expr()
    data class  Divide(val left: Expr, val right: Expr) : Expr()

}