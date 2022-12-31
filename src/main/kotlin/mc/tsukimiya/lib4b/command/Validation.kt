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

    fun isDouble(str: String): Boolean {
        return try {
            str.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
