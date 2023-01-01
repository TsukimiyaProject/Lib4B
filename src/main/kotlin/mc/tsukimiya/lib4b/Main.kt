package mc.tsukimiya.lib4b

import mc.tsukimiya.lib4b.db.DatabaseConnector
import mc.tsukimiya.lib4b.lang.MessageFormatter
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var instance: Main
    }

    lateinit var formatter: MessageFormatter

    override fun onEnable() {
        instance = this

        saveDefaultConfig()
        formatter = MessageFormatter(config)

        DatabaseConnector.connect(config)
    }
}
