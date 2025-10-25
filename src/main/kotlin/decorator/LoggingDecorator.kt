package decorator

class LoggingDecorator(
    inner: Transaction
) : TransactionDecorator(inner) {
    override fun execute() {
        println("Logging Transaction begin")
        inner.execute()
        println("Logging Transaction end")
    }
}