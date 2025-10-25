import builder.TransactionBuilder
import factory.AccountFactory
import factory.AccountType
import singletonobserver.NotificationService
import strategy.FixedFee
import strategy.NoFee
import strategy.PercentFee

private val notifyService = NotificationService.instance

private val noFee = NoFee()
private val fixedFee = FixedFee(10.0)
private val percentFee = PercentFee(5.0)

fun main() {
    println("Hello Kotlin")

    val depositAccount = BankAccount(
        account = AccountFactory.create(
            accountNumber = "123456789",
            accountName = "HOANG QUOC ANH",
            accountType = AccountType.Deposit
        )
    )
    val salaryAccount = BankAccount(
        account = AccountFactory.create(
            accountNumber = "11112222",
            accountName = "AnhHQ Salary",
            accountType = AccountType.Salary
        )
    )

    depositAccount.addObserver(notifyService)
    salaryAccount.addObserver(notifyService)

    val depositTransaction = TransactionBuilder()
        .setAccount(depositAccount)
        .setAmount(1000.0)
        .setDescription("Hello deposit")
        .setFeeStrategy(fixedFee)
        .enableNotify()
        .enableLogging()
        .build()

    depositTransaction.execute()

    println("---")

    val withdrawTransaction = TransactionBuilder()
        .setAccount(depositAccount)
        .setAmount(-500.0)
        .setDescription("Hello withdraw")
        .setFeeStrategy(percentFee)
        .enableNotify()
        .enableLogging()
        .build()

    withdrawTransaction.execute()

    val salaryTransaction = TransactionBuilder()
        .setAccount(salaryAccount)
        .setAmount(1234.0)
        .setDescription("Hello salary")
        .setFeeStrategy(noFee)
        .enableNotify()
        .enableLogging()
        .build()

    salaryTransaction.execute()

    println("---")
    println("Transaction History: ${depositAccount.account.accountName} (${depositAccount.account.accountNumber})")
    depositAccount.history.forEach {
        println("${it.description}: Balance: ${it.oldBalance} -> ${it.newBalance} (Amount: ${it.amount} - Fee: ${it.fee})")
    }

    println("---")
    println("Transaction History: ${salaryAccount.account.accountName} (${salaryAccount.account.accountNumber})")
    salaryAccount.history.forEach {
        println("${it.description}: Balance: ${it.oldBalance} -> ${it.newBalance} (Amount: ${it.amount} - Fee: ${it.fee})")
    }

}