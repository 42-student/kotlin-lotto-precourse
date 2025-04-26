package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoMachineTest {
	private val lottoMachine = LottoMachine()

	@Test
	fun `returns correct number of lotto tickets based on amount` () {
		val tickets = lottoMachine.buyTickets(12000)
		assertThat(tickets).hasSize(12)
	}

	@Test
	fun `each lotto ticket contains 6 unique numbers within 1 to 45` () {
		val tickets = lottoMachine.buyTickets(3000)

		for (ticket in tickets) {
			val numbers = ticket.numbers
			assertThat(numbers.size).isEqualTo(6)

			val uniqueNumbers = numbers.distinct()
			assertThat(uniqueNumbers.size).isEqualTo(6)

			val allNumbersInRange = numbers.all { it in 1..45 }
			assertThat(allNumbersInRange).isTrue()
		}
	}

	@Test
	fun `returns empty list for 0 amount` () {
		val tickets = lottoMachine.buyTickets(0)
		assertThat(tickets).isEmpty()
	}

	@Test
	fun `returns empty list for negative amount` () {
		val tickets = lottoMachine.buyTickets(-3000)
		assertThat(tickets).isEmpty()
	}

	@Test
	fun `handles large input amount correctly` () {
		val tickets = lottoMachine.buyTickets(1000000000)
		assertThat(tickets).hasSize(1000000)
	}
}
