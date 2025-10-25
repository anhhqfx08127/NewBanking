package strategy

interface FeeStrategy {
    fun fee(amount: Double) : Double
}

data class FixedFee(
    val fixed: Double
) : FeeStrategy {
    override fun fee(amount: Double): Double {
        return fixed
    }
}

data class PercentFee(
    val percent: Double
) : FeeStrategy {
    override fun fee(amount: Double): Double {
        return amount * percent / 100
    }
}

class NoFee : FeeStrategy {
    override fun fee(amount: Double): Double {
        return 0.0
    }
}