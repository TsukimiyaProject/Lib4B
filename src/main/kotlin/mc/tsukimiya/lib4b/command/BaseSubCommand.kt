package mc.tsukimiya.lib4b.command

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

abstract class BaseSubCommand(
    val name: String,
    val usage: String,
    val permission: String,
    val aliases: Array<String> = arrayOf()
) : CommandRunnable, RestrictSenderTrait {
    fun testPermission(sender: CommandSender): Boolean {
        if (permission.isEmpty()) {
            return true
        }

        permission.split(";").forEach {
            if (sender.hasPermission(it)) {
                return true
            }
        }

        sender.sendMessage(Bukkit.permissionMessage())
        return false
    }
}
