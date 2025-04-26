package lotto

class OutputView {
	fun printTickets(tickets: List<Lotto>) {
		println("\nYou have purchased ${tickets.size} tickets.")
		for (ticket in tickets) {
			println(ticket.numbers.sorted())
		}
	}

	fun printResult(result: Map<Rank, Int>, purchaseAmount: Int) {
		println("\nWinning Statistics\n---")
		for (rank in Rank.entries) {
			if (rank != Rank.NONE) {
				val ticketCount = result[rank] ?: 0
				println("${rank.getPrizeText()} – $ticketCount tickets")
			}
		}
		val profitRate = calculateProfitRate(result, purchaseAmount)
		println("Total return rate is ${"%.1f".format(profitRate)}%.")
	}

	private fun calculateProfitRate(result: Map<Rank, Int>, purchaseAmount: Int): Double {
		var totalWinnings = 0
		for ((rank, count) in result) {
			totalWinnings += rank.prizeMoney * count
		}
		val profitRate = (totalWinnings.toDouble() / purchaseAmount) * 100
		return profitRate
	}
}
