package mc.tsukimiya.lib4b.command

import mc.tsukimiya.lib4b.command.exception.NotFoundPluginCommandException
import org.bukkit.plugin.java.JavaPlugin

class CommandRegistrar(private val plugin: JavaPlugin) {
    fun registerCommand(baseCommand: BaseCommand, vararg subCommand: BaseSubCommand) {
        subCommand.forEach {
            baseCommand.registerSubCommands(it)
        }
        val command = plugin.getCommand(baseCommand.name)
            ?: throw NotFoundPluginCommandException(baseCommand.name, plugin.name)
        command.setExecutor(baseCommand)
        command.tabCompleter = baseCommand
    }
}
