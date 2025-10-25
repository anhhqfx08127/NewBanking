package singletonobserver

import BankAccount

class NotificationService private constructor() : AccountObserver {

    companion object {
        val instance by lazy { NotificationService() }
    }

    override fun onBalanceChanged(account: BankAccount, newBalance: Double) {
        println(
            """
                .....
                [Balance changed]
                Account: ${account.account.accountName} (${account.account.accountNumber})
                New balance: ${account.balance}
                [Balance changed]
                .....
        """.trimIndent()
        )
    }
}