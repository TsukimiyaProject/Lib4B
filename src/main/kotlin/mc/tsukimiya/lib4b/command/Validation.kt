package mc.tsukimiya.lib4b.command

object Validation {
    fun isInt(str: String): Boolean {
        return try {
            str.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isNaturalNumber(str: String): Boolean {
        return try {
            val i = str.toInt()
            i >= 0
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isDouble(str: String): Boolean {
        return try {
            str.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isPositiveNumber(str: String): Boolean {
        return try {
            val d = str.toDouble()
            d >= 0.0
        } catch (e: NumberFormatException) {
            false
        }
    }
}
