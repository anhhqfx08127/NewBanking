package singletonobserver

import BankAccount

interface AccountObserver {
    fun onBalanceChanged(
        account: BankAccount,
        newBalance: Double
    )
}