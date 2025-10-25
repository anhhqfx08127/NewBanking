package builder

import BankAccount
import BasicTransaction
import decorator.LoggingDecorator
import decorator.Transaction
import strategy.FeeStrategy
import strategy.NoFee

class TransactionBuilder {
    private var account: BankAccount? = null
    private var amount: Double = 0.0
    private var description: String = ""
    private var feeStrategy: FeeStrategy = NoFee()

    private var withNotify: Boolean = false

    fun setAccount(account: BankAccount) = apply { this.account = account }
    fun setAmount(amount: Double) = apply { this.amount = amount }
    fun setDescription(description: String) = apply { this.description = description }
    fun setFeeStrategy(feeStrategy: FeeStrategy) = apply { this.feeStrategy = feeStrategy }

    fun enableNotify() = apply { this.withNotify = true }

    fun build(): Transaction {
        return account?.let { account ->
            var transaction: Transaction = BasicTransaction(
                account = account,
                amount = amount,
                description = description,
                feeStrategy = feeStrategy
            )

            if (withNotify) {
                transaction = LoggingDecorator(transaction)
            }

            transaction
        } ?: throw NullPointerException("BankAccount should not be null")

    }
}