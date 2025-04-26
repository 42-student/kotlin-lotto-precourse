package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
	fun buyTickets(amount: Int): List<Lotto> {
		val ticketCount = amount / LottoConstants.TICKET_PRICE
		val tickets = mutableListOf<Lotto>()
		for (i in 1..ticketCount) {
			val numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER, LottoConstants.NUMBER_COUNT)
			val ticket = Lotto(numbers)
			tickets.add(ticket)
		}
		return tickets
	}
}
