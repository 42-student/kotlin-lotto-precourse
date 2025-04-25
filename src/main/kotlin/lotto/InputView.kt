package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
	fun readPurchaseAmount(): Int {
		println("Please enter the purchase amount.")
		val input = Console.readLine()
		val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")
		if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
		return amount
	}

	fun readWinningNumbers(): List<Int> {
		println("\nPlease enter last week's winning numbers.")
		val input = Console.readLine()
		val numbers = parseInputToNumbers(input)
		validateNumberCount(numbers)
		validateUniqueNumbers(numbers)
		validateNumberRange(numbers)
		return numbers
	}

	private fun parseInputToNumbers(input: String): List<Int> {
		val inputSplit = input.split(",")
		val inputTrim = inputSplit.map { it.trim() }
		val numbers = mutableListOf<Int>()
		for (str in inputTrim) {
			val number = str.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] '$str' is not a valid number.")
			numbers.add(number)
		}
		return numbers
	}

	private fun validateNumberCount(numbers: List<Int>) {
		if (numbers.size != 6) {
			throw IllegalArgumentException("[ERROR] You must enter exactly 6 numbers.")
		}
	}

	private fun validateUniqueNumbers(numbers: List<Int>) {
		if (numbers.distinct().size != 6) {
			throw IllegalArgumentException("[ERROR] Numbers must be unique.")
		}
	}

	private fun validateNumberRange(numbers: List<Int>) {
		val allNumbersInRange = numbers.all { it in 1..45 }
		if (!allNumbersInRange) {
			throw IllegalArgumentException("[ERROR] Numbers must be in range 1 to 45.")
		}
	}

	fun readBonusNumber(): Int {
		println("\nPlease enter the bonus number.")
		val input = Console.readLine()
		val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number is not valid.")
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw IllegalArgumentException("[ERROR] Bonus number must be in range 1 to 45.")
		}
		return bonusNumber
	}
}
