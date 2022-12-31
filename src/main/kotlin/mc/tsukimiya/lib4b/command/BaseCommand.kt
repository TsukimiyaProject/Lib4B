package mc.tsukimiya.lib4b.command

import mc.tsukimiya.lib4b.command.exception.RegisteredSubCommandException
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

abstract class BaseCommand(val name: String) : TabExecutor, CommandRunnable, RestrictSenderTrait {
    private val subCommands = mutableMapOf<String, BaseSubCommand>()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args != null && args.isNotEmpty()) {
            val subCommand = subCommands[args[0]]
            if (subCommand != null) {
                if (!subCommand.testRestriction(sender) || !subCommand.testPermission(sender)) {
                    return true
                }
                if (!subCommand.onRun(sender, command, args[0], args.drop(1).toTypedArray())) {
                    sender.sendMessage(subCommand.usage)
                }
                return true
            }
        }

        if (!testRestriction(sender)) {
            return true
        }
        return onRun(sender, command, label, args)
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String>? {
        if (args?.size == 1) {
            return subCommands.keys.filter { it.startsWith(args[0]) }.toMutableList()
        }

        return null
    }

    fun registerSubCommands(vararg commands: BaseSubCommand) {
        commands.forEach { command ->
            (command.aliases + command.name).distinct().forEach { key ->
                if (!subCommands.containsKey(key)) {
                    subCommands[key] = command
                } else {
                    throw RegisteredSubCommandException(key, name)
                }
            }
        }
    }
}
