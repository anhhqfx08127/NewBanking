package factory

class AccountFactory private constructor() {

    companion object {
        fun create(
            accountNumber: String,
            accountName: String,
            accountType: AccountType
        ): Account {
            println("${accountType.name} account created: $accountName ($accountNumber)")
            return when (accountType) {
                AccountType.Deposit -> DepositAccount(accountNumber, accountName)
                AccountType.Overdraft -> OverdraftAccount(accountNumber, accountName)
                AccountType.Salary -> SalaryAccount(accountNumber, accountName)
            }
        }
    }
}