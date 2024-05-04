package mc.tsukimiya.lib4b.command

import mc.tsukimiya.lib4b.command.exception.NotFoundPluginCommandException
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabExecutor
import org.bukkit.plugin.java.JavaPlugin

object CommandRegistrar {
    fun registerCommands(plugin: JavaPlugin, commands: MutableMap<String, CommandExecutor>) {
        commands.forEach { (name, executor) ->
            val command = plugin.getCommand(name) ?: throw NotFoundPluginCommandException(name, plugin.name)
            command.setExecutor(executor)
            if (executor is TabExecutor) {
                command.tabCompleter = executor
            }
        }
    }
}
