import platform.posix.sqrt

fun addAndSquareRoot(num1: Int, num2: Int): Double {
    return sqrt(add(num1, num2))
}