internal actual fun writeLogMessage(message: String, logLevel: LogLevel) {
    println("Running in Native: [$logLevel]: $message")
}