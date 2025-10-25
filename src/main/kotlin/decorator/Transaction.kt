package decorator

interface Transaction {
    fun execute()
}

abstract class TransactionDecorator(
    val inner: Transaction
) : Transaction {
    override fun execute() {
        inner.execute()
    }
}