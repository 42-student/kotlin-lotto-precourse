package lotto

class Lotto(private val _numbers: List<Int>) {
    init {
        require(_numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
		require(_numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
		require(_numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be in range 1 and 45." }
    }

    val numbers: List<Int> get() = _numbers
}
