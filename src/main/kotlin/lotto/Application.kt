package lotto

//import camp.nextstep.edu.missionutils.Console
//import camp.nextstep.edu.missionutils.Randoms

fun main() {
	val purchaseAmount = InputView().readPurchaseAmount()
	val tickets = LottoMachine().buyTickets(purchaseAmount)
	OutputView().printTickets(tickets)
	val winningNumbers = InputView().readWinningNumbers()
	val bonusNumber = InputView().readBonusNumber()
	val winningResult = LottoResult.calculate(tickets, winningNumbers, bonusNumber)
	for ((rank, count) in winningResult) {
		if (count > 0 && rank != Rank.NONE) {
			println("${rank.getPrizeText()} - $count tickets")
		}
	}
}

// fun main() {
//     // ask user to enter the amount
// 	println("Please enter the purchase amount.")
// 	val purchaseAmount = Console.readLine().toInt()

// 	// calculate the tickets number
// 	val ticketsNbr = purchaseAmount / 1000

// 	// generate tickets
// 	val tickets: MutableList<MutableList<Int>> = MutableList(ticketsNbr) { Randoms.pickUniqueNumbersInRange(1, 45, 6) }

// 	// output tickets
// 	println("\nYou have purchased $ticketsNbr tickets.")
// 	for (ticket in tickets) {
// 		println(ticket)
// 	}

// 	// ask user to input the winning numbers
// 	println("\nPlease enter last week's winning numbers")
// 	val winningNbrs = Console.readLine().split(",").map { it.toInt() }

// 	// ask user to enter a bonus number
// 	println("\nPlease enter the bonus number.")
// 	val bonusNbr = Console.readLine().toInt()

// 	val rankStats = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 404 to 0)

// 	// compare each ticket with winning numbers and bonus number
// 	for (ticket in tickets) {
// 		val matchCheck = ticket.count() { it in winningNbrs } //!!!!!!!!!!!!!!
// 		val hasBonus = bonusNbr in ticket

// 		// calculate prize for each ticket
// 		val rank = when {
// 			matchCheck == 6 -> 1
// 			matchCheck == 5 && hasBonus -> 2
// 			matchCheck == 5 -> 3
// 			matchCheck == 4 -> 4
// 			matchCheck == 3 -> 5
// 			else -> 404
// 		}

// 		rankStats[rank] = rankStats[rank]!! + 1
// 	}

// 	// print winning statistics
// 	println("\nWinning Statistics")
// 	println("---")
// 	println("3 Matches (5,000 KRW) - ${rankStats[5]} tickets")
// 	println("4 Matches (50,000 KRW) - ${rankStats[4]} tickets")
// 	println("5 Matches (1,500,000 KRW) - ${rankStats[3]} tickets")
// 	println("5 Matches + Bonus Ball (30,000,000 KRW) - ${rankStats[2]} tickets")
// 	println("6 Matches (2,000,000,000 KRW) - ${rankStats[1]} tickets")

// 	// calculate and display the profit rate
// 	val totalWin = rankStats[1]!! * 2_000_000_000L + rankStats[2]!! * 30_000_000L +
// 		rankStats[3]!! * 1_500_000L + rankStats[4]!! * 50_000L + rankStats[5]!! * 5_000L
	
// 	val profitRate = totalWin.toDouble() / purchaseAmount.toDouble() * 100
// 	println("Total return rate is ${"%.1f".format(profitRate)}%.")
// }
