import factory.Account
import iterator.TransactionHistory
import singletonobserver.AccountObserver
import state.AccountState
import state.ActiveState

data class BankAccount(
    val account: Account,
    var balance: Double = 0.0,
    var state: AccountState = ActiveState()
) {
    val history = TransactionHistory(

    )
    val observers = mutableListOf<AccountObserver>()

    fun addObserver(observer: AccountObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: AccountObserver) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        observers.forEach {
            it.onBalanceChanged(this, balance)
        }
    }

    fun deposit(amount: Double, fee: Double, description: String) {
        state.deposit(this, amount, fee, description)
    }

    fun withdraw(amount: Double, fee: Double, description: String) {
        state.withdraw(this, amount, fee, description)
    }

    fun freeze() {
        state.freeze(this)
    }

    fun close() {
        state.close(this)
    }
}