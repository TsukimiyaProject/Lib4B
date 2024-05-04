package mc.tsukimiya.lib4b

import mc.tsukimiya.lib4b.lang.MessageFormatter
import org.bukkit.plugin.java.JavaPlugin

class Lib4B : JavaPlugin() {
    companion object {
        lateinit var instance: Lib4B
    }

    lateinit var formatter: MessageFormatter

    override fun onEnable() {
        instance = this

        saveDefaultConfig()
        formatter = MessageFormatter(config)
    }
}
