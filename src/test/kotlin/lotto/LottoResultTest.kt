package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoResultTest {
	@Test
	fun `getRank correctly returns rank based on matches and bonus`() {
		assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST)
		assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND)
		assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD)
		assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH)
		assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH)
		assertThat(Rank.getRank(2, false)).isEqualTo(Rank.NONE)
		assertThat(Rank.getRank(1, false)).isEqualTo(Rank.NONE)
		assertThat(Rank.getRank(0, false)).isEqualTo(Rank.NONE)
	}

	@Test
	fun `calculate returns correct count of ranks`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7
		val tickets = listOf(
			Lotto(listOf(1, 2, 3, 4, 5, 6)),
			Lotto(listOf(1, 2, 3, 4, 5, 7)),
			Lotto(listOf(1, 2, 3, 4, 5, 11)),
			Lotto(listOf(1, 2, 3, 4, 11, 22)),
			Lotto(listOf(1, 2, 3, 11, 22, 33)),
			Lotto(listOf(1, 2, 11, 22, 33, 44))
		)
		val result = LottoResult.calculate(tickets, winningNumbers, bonusNumber)

		assertThat(result[Rank.FIRST]).isEqualTo(1)
		assertThat(result[Rank.SECOND]).isEqualTo(1)
		assertThat(result[Rank.THIRD]).isEqualTo(1)
		assertThat(result[Rank.FOURTH]).isEqualTo(1)
		assertThat(result[Rank.FIFTH]).isEqualTo(1)
		assertThat(result[Rank.NONE]).isEqualTo(1)
	}

	@Test
	fun `getPrizeText correctly returns format for each rank`() {
		assertThat(Rank.FIFTH.getPrizeText()).isEqualTo("3 Matches (5,000 KRW)")
		assertThat(Rank.FOURTH.getPrizeText()).isEqualTo("4 Matches (50,000 KRW)")
		assertThat(Rank.THIRD.getPrizeText()).isEqualTo("5 Matches (1,500,000 KRW)")
		assertThat(Rank.SECOND.getPrizeText()).isEqualTo("5 Matches + Bonus Ball (30,000,000 KRW)")
		assertThat(Rank.FIRST.getPrizeText()).isEqualTo("6 Matches (2,000,000,000 KRW)")
		assertThat(Rank.NONE.getPrizeText()).isEqualTo("No Prize")
	}
}
