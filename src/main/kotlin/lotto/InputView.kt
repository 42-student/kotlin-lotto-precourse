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
}
