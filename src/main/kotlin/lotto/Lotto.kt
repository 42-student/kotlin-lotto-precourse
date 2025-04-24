package lotto

class Lotto(private val _numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    val numbers: List<Int> get() = _numbers
}
