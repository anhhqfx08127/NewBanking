import decorator.Transaction
import iterator.TransactionRecord
import strategy.FeeStrategy

data class BasicTransaction(
    val account: BankAccount,
    val amount: Double,
    val description: String,
    val feeStrategy: FeeStrategy
) : Transaction {
    override fun execute() {
        val oldBalance = account.balance
        val fee = feeStrategy.fee(amount)

        if(amount > 0) {
            account.deposit(amount, fee, description)
        } else {
            account.withdraw(amount, fee, description)
        }

        if(oldBalance != account.balance) {
            account.history.add(TransactionRecord(
                oldBalance = oldBalance,
                amount = amount,
                fee = fee,
                newBalance = account.balance,
                description = description
            ))
        }
    }
}