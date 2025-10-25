package factory


enum class AccountType {
    Deposit,
    Overdraft,
    Salary
}

interface Account {
    val accountNumber: String
    val accountName: String
    val accountType: AccountType
}

data class DepositAccount(
    override val accountNumber: String,
    override val accountName: String,
    override val accountType: AccountType = AccountType.Deposit
) : Account

data class OverdraftAccount(
    override val accountNumber: String,
    override val accountName: String,
    override val accountType: AccountType = AccountType.Overdraft
) : Account

data class SalaryAccount(
    override val accountNumber: String,
    override val accountName: String,
    override val accountType: AccountType = AccountType.Salary
) : Account