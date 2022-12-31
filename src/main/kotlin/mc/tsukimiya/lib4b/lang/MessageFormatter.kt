package mc.tsukimiya.lib4b.lang

import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration

class MessageFormatter(private val config: FileConfiguration) {
    companion object {
        const val COLOR_PREFIX = '&'
    }

    fun formatMessage(key: String, vararg replace: String): String {
        var message = config.getString(key) ?: return key

        message = ChatColor.translateAlternateColorCodes(COLOR_PREFIX, message)
        MessagePrefix.values().forEach {
            message = message.replace(it.search, it.replace)
        }
        replace.forEachIndexed { index, s ->
            message = message.replace("%${index}", s)
        }

        return message
    }
}
