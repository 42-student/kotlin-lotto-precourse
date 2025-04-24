package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
	fun buyTickets(amount: Int): List<Lotto> {
		val ticketCount = amount / 1000
		val tickets = mutableListOf<Lotto>()
		for (i in 1..ticketCount) {
			val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
			val ticket = Lotto(numbers)
			tickets.add(ticket)
		}
		return tickets
	}
}
