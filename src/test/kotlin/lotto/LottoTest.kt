package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
	@Test
	fun `throws an exception when lotto numbers exceed six`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
		}
	}

	@Test
	fun `throws an exception when lotto numbers are fewer than six`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5))
		}
	}

	@Test
	fun `throws an exception when lotto numbers are empty`() {
		assertThrows<IllegalArgumentException> {
			Lotto(emptyList())
		}
	}

	@Test
	fun `throws an exception when lotto numbers contain duplicates`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 5))
		}
	}

	@Test
	fun `throws an exception when lotto number is below range`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(0, 1, 2, 3, 4, 5))
		}
	}

	@Test
	fun `throws an exception when lotto number is above range`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 46))
		}
	}

	@Test
	fun `creates a valid Lotto object with 6 numbers within range and no duplicates`() {
		val lotto = Lotto(listOf(2, 4, 12, 21, 36, 42))
		assertThat(lotto.numbers).containsExactlyInAnyOrder(2, 4, 12, 21, 36, 42)
	}
}
