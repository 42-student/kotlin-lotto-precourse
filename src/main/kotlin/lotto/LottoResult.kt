package lotto

enum class Rank(val matches: Int, val needsBonus: Boolean, val prizeMoney: Int) {
	FIFTH(3, false, LottoConstants.FIFTH_PRIZE),
	FOURTH(4, false, LottoConstants.FOURTH_PRIZE),
	THIRD(5, false, LottoConstants.THIRD_PRIZE),
	SECOND(5, true, LottoConstants.SECOND_PRIZE),
	FIRST(6, false, LottoConstants.FIRST_PRIZE),
	NONE(0, false, 0);

	fun getPrizeText(): String {
		return when (this) {
			FIRST -> "6 Matches (${"%,d".format(LottoConstants.FIRST_PRIZE)} KRW)"
			SECOND -> "5 Matches + Bonus Ball (${"%,d".format(LottoConstants.SECOND_PRIZE)} KRW)"
			THIRD -> "5 Matches (${"%,d".format(LottoConstants.THIRD_PRIZE)} KRW)"
			FOURTH -> "4 Matches (${"%,d".format(LottoConstants.FOURTH_PRIZE)} KRW)"
			FIFTH -> "3 Matches (${"%,d".format(LottoConstants.FIFTH_PRIZE)} KRW)"
			NONE -> "No Prize"
		}
	}

	companion object {
		fun getRank(numberOfMatches: Int, hasBonus: Boolean): Rank {
			if (numberOfMatches == 6) return FIRST
			if (numberOfMatches == 5 && hasBonus) return SECOND
			if (numberOfMatches == 5) return THIRD
			if (numberOfMatches == 4) return FOURTH
			if (numberOfMatches == 3) return FIFTH
			return NONE
		}
	}
}

object LottoResult {
	fun calculate(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
		val prizeCounts = mutableMapOf<Rank, Int>()
		for (ticket in tickets) {
			val matchingNumbers = ticket.numbers.count { it in winningNumbers }
			val hasBonus = bonusNumber in ticket.numbers
			val prizeRank = Rank.getRank(matchingNumbers, hasBonus)
			val currentCount = prizeCounts.getOrDefault(prizeRank, 0)
			prizeCounts[prizeRank] = currentCount + 1
		}
		return prizeCounts
	}

	fun calculateProfitRate(result: Map<Rank, Int>, purchaseAmount: Int): Double {
		var totalWinnings = 0
		for ((rank, count) in result) {
			totalWinnings += rank.prizeMoney * count
		}
		val profitRate = (totalWinnings.toDouble() / purchaseAmount) * 100
		return profitRate
	}
}
