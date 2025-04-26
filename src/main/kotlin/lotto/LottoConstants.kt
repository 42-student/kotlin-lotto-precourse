package lotto

object LottoConstants {
	const val TICKET_PRICE = 1_000
	const val NUMBER_COUNT = 6
	const val MIN_NUMBER = 1
	const val MAX_NUMBER = 45
	val PRIZE_AMOUNT = mapOf(
		1 to 2_000_000_000,
		2 to 30_000_000,
		3 to 1_500_000,
		4 to 50_000,
		5 to 5_000
	)
}
