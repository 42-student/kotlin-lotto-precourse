package lotto

fun main() {
	val purchaseAmount = InputView().readPurchaseAmount()
	val tickets = LottoMachine().buyTickets(purchaseAmount)
	OutputView().printTickets(tickets)
	val winningNumbers = InputView().readWinningNumbers()
	val bonusNumber = InputView().readBonusNumber()
	val winningResult = LottoResult.calculate(tickets, winningNumbers, bonusNumber)
	OutputView().printResult(winningResult, purchaseAmount)
}
