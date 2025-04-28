package lotto

class Lotto(private val _numbers: List<Int>) {
    init {
        require(_numbers.size == LottoConstants.NUMBER_COUNT) { "${LottoConstants.ERROR_PREFIX} Lotto must contain exactly 6 numbers." }
		require(_numbers.distinct().size == LottoConstants.NUMBER_COUNT) { "${LottoConstants.ERROR_PREFIX} Lotto numbers must be unique." }
		require(_numbers.all { it in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER }) { "${LottoConstants.ERROR_PREFIX} Lotto numbers must be in range 1 and 45." }
    }

    val numbers: List<Int> get() = _numbers
}
