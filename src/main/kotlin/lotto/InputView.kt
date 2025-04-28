package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
	fun readPurchaseAmount(): Int {
		while (true) {
			try {
				println("Please enter the purchase amount.")
				val amount = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Invalid number.")
				validatePurchaseAmount(amount)
				return amount
			} catch (e: IllegalArgumentException) {
				println(e.message)
			}
		}
	}

	private fun validatePurchaseAmount(amount: Int) {
		if (amount % LottoConstants.TICKET_PRICE != 0) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Amount must be divisible by 1000.")
		}
		if (amount <= 0) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Amount must be positive.")
		}
	}

	fun readWinningNumbers(): List<Int> {
		while (true) {
			try {
				println("\nPlease enter last week's winning numbers.")
				val numbers = parseInputToNumbers(Console.readLine())
				validateWinningNumbers(numbers)
				return numbers
			} catch (e: IllegalArgumentException) {
				println(e.message)
			}
		}
	}

	private fun parseInputToNumbers(input: String): List<Int> {
		val inputSplit = input.split(",")
		val inputTrim = inputSplit.map { it.trim() }
		val numbers = mutableListOf<Int>()
		for (str in inputTrim) {
			val number = str.toIntOrNull() ?: throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} '$str' is not a valid number.")
			numbers.add(number)
		}
		return numbers
	}

	private fun validateWinningNumbers(numbers: List<Int>) {
		if (numbers.size != LottoConstants.NUMBER_COUNT) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} You must enter exactly 6 numbers.")
		}
		if (numbers.distinct().size != LottoConstants.NUMBER_COUNT) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Numbers must be unique.")
		}
		val allNumbersInRange = numbers.all { it in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER }
		if (!allNumbersInRange) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Numbers must be in range 1 to 45.")
		}
	}

	fun readBonusNumber(winningNumbers: List<Int>): Int {
		while (true) {
			try {
				println("\nPlease enter the bonus number.")
				val bonusNumber = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Bonus number is not valid.")
				validateBonusNumber(bonusNumber, winningNumbers)
				return bonusNumber
			} catch (e: IllegalArgumentException) {
				println(e.message)
			}
		}
	}

	private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
		if (bonusNumber < LottoConstants.MIN_NUMBER || bonusNumber > LottoConstants.MAX_NUMBER) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Bonus number must be in range 1 to 45.")
		}
		if (bonusNumber in winningNumbers) {
			throw IllegalArgumentException("${LottoConstants.ERROR_PREFIX} Bonus number must differ from the winning numbers.")
		}
	}
}
