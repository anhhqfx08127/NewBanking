package state

import BankAccount
import kotlin.math.absoluteValue

interface AccountState {
    fun deposit(account: BankAccount, amount: Double, fee: Double, description: String)
    fun withdraw(account: BankAccount, amount: Double, fee: Double, description: String)
    fun freeze(account: BankAccount)
    fun close(account: BankAccount)
}

class ActiveState : AccountState {
    override fun deposit(account: BankAccount, amount: Double, fee: Double, description: String) {
        val total = amount.absoluteValue - fee.absoluteValue
        val newBalance = account.balance + total

        println("Deposit transaction")
        println("Account: ${account.account.accountName} (${account.account.accountNumber})")
        println("Amount: $amount")
        println("Fee: $fee")
        println("Total: $total")
        println("New balance: $newBalance")

        account.balance = newBalance
        account.notifyObservers()
    }

    override fun withdraw(account: BankAccount, amount: Double, fee: Double, description: String) {
        val total = amount.absoluteValue + fee.absoluteValue
        val newBalance = account.balance - total

        if (newBalance < 0) {
            println("Error transaction: Account balance can\'t be negative")
            return
        }

        println("Withdraw transaction")
        println("Account: ${account.account.accountName} (${account.account.accountNumber})")
        println("Current balance: ${account.balance}")
        println("Amount: $amount")
        println("Fee: ${fee.absoluteValue}")
        println("Total: $total")
        println("New balance: $newBalance")

        account.balance = newBalance
        account.notifyObservers()
    }

    override fun freeze(account: BankAccount) {
        println("Account has been frozen")
    }

    override fun close(account: BankAccount) {
        println("Account has been closed")
    }
}