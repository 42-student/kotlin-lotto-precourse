package lotto

enum class Rank(val matches: Int, val needsBonus: Boolean, val prizeMoney: Int) {
	FIFTH(3, false, LottoConstants.PRIZE_AMOUNT[5]!!),
	FOURTH(4, false, LottoConstants.PRIZE_AMOUNT[4]!!),
	THIRD(5, false, LottoConstants.PRIZE_AMOUNT[3]!!),
	SECOND(5, true, LottoConstants.PRIZE_AMOUNT[2]!!),
	FIRST(6, false, LottoConstants.PRIZE_AMOUNT[1]!!),
	NONE(0, false, 0);

	fun getPrizeText(): String {
		return when (this) {
			FIRST -> "6 Matches (${"%,d".format(LottoConstants.PRIZE_AMOUNT[1])} KRW)"
			SECOND -> "5 Matches + Bonus Ball (${"%,d".format(LottoConstants.PRIZE_AMOUNT[2])} KRW)"
			THIRD -> "5 Matches (${"%,d".format(LottoConstants.PRIZE_AMOUNT[3])} KRW)"
			FOURTH -> "4 Matches (${"%,d".format(LottoConstants.PRIZE_AMOUNT[4])} KRW)"
			FIFTH -> "3 Matches (${"%,d".format(LottoConstants.PRIZE_AMOUNT[5])} KRW)"
			NONE -> "No Prize"
		}
	}

	companion object {
		fun getRank(numberOfMatches: Int, hasBonus: Boolean): Rank {
			return when {
				numberOfMatches == 6 -> FIRST
				numberOfMatches == 5 && hasBonus -> SECOND
				numberOfMatches == 5 -> THIRD
				numberOfMatches == 4 -> FOURTH
				numberOfMatches == 3 -> FIFTH
				else -> NONE
			}
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
}
