package iterator

data class TransactionRecord(
    val oldBalance: Double,
    val amount: Double,
    val fee: Double,
    val newBalance: Double,
    val description: String
)

class TransactionHistory : Iterable<TransactionRecord> {

    private val history = mutableListOf<TransactionRecord>()

    fun add(transaction: TransactionRecord) {
        history.add(transaction)
    }

    override fun iterator(): Iterator<TransactionRecord> {
        return history.iterator()
    }

}