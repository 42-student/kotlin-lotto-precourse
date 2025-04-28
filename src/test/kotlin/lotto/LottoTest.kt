package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
	@Test
	fun `throws an exception when lotto numbers exceed six`() {
		val exception = assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
		}
		assertThat(exception.message).startsWith(ERROR_MESSAGE)
	}

	@Test
	fun `throws an exception when lotto numbers are fewer than six`() {
		val exception = assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5))
		}
		assertThat(exception.message).startsWith(ERROR_MESSAGE)
	}

	@Test
	fun `throws an exception when lotto numbers are empty`() {
		val exception = assertThrows<IllegalArgumentException> {
			Lotto(emptyList())
		}
		assertThat(exception.message).startsWith(ERROR_MESSAGE)
	}

	@Test
	fun `throws an exception when lotto numbers contain duplicates`() {
		val exception = assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 5))
		}
		assertThat(exception.message).startsWith(ERROR_MESSAGE)
	}

	@Test
	fun `throws an exception when lotto number is below range`() {
		val exception = assertThrows<IllegalArgumentException> {
			Lotto(listOf(0, 1, 2, 3, 4, 5))
		}
		assertThat(exception.message).startsWith(ERROR_MESSAGE)
	}

	@Test
	fun `throws an exception when lotto number is above range`() {
		val exception = assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 46))
		}
		assertThat(exception.message).startsWith(ERROR_MESSAGE)
	}

	@Test
	fun `creates a valid Lotto object with 6 numbers within range and no duplicates`() {
		val lotto = Lotto(listOf(2, 4, 12, 21, 36, 42))
		assertThat(lotto.numbers).containsExactlyInAnyOrder(2, 4, 12, 21, 36, 42)
	}

	companion object {
		private const val ERROR_MESSAGE: String = "[ERROR]"
	}
}
