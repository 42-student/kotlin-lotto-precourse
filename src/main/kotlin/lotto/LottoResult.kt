package lotto

enum class Rank(val matches: Int, val needsBonus: Boolean, val prizeMoney: Int) {
	FIRST(6, false, 2_000_000_000),
	SECOND(5, true, 30_000_000),
	THIRD(5, false, 1_500_000),
	FOURTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	NONE(0, false, 0);

	fun getPrizeText(): String {
		return when (this) {
			FIRST -> "6 Matches (2,000,000,000 KRW)"
			SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
			THIRD -> "5 Matches (1,500,000 KRW)"
			FOURTH -> "4 Matches (50,000 KRW)"
			FIFTH -> "3 Matches (5,000 KRW)"
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
