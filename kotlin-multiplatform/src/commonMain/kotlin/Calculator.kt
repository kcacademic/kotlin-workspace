fun add(num1: Int, num2: Int): Double {
    val sum = num1 + num2
    writeLogMessage(sum.toString(), LogLevel.DEBUG)
    return sum.toDouble()
}

