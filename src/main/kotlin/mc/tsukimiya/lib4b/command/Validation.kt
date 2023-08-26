package mc.tsukimiya.lib4b.command

object Validation {
    /**
     * Intか
     *
     * @param str
     * @return
     */
    fun isInt(str: String): Boolean {
        return try {
            str.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    /**
     * 自然数か(ULongによるチェック)
     *
     * @param str
     * @return
     */
    fun isNaturalNumber(str: String): Boolean {
        return try {
            str.toULong()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    /**
     * Doubleか
     *
     * @param str
     * @return
     */
    fun isDouble(str: String): Boolean {
        return try {
            str.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    /**
     * 正の実数か
     *
     * @param str
     * @return
     */
    fun isPositiveNumber(str: String): Boolean {
        return try {
            val d = str.toDouble()
            d >= 0.0
        } catch (e: NumberFormatException) {
            false
        }
    }
}
