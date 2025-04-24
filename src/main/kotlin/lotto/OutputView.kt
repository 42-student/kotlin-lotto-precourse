package lotto

object OutputView {
	fun printTickets(tickets: List<Lotto>) {
		println("\nYou have purchased ${tickets.size} tickets.")
		for (ticket in tickets) {
			println(ticket.numbers)
		}
	}
}
