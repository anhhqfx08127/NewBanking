package decorator

import BankAccount

class NotificationDecorator(
    inner: Transaction,
    private val account: BankAccount
) : TransactionDecorator(inner) {
    override fun execute() {
        inner.execute()
        println("Push notification to account: ${account.account.accountName} (${account.account.accountNumber})")
        account.notifyObservers()
    }
}