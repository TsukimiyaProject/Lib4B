package mc.tsukimiya.lib4b.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

interface CommandRunnable {
    fun onRun(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean
}
