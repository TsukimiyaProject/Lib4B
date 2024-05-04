package mc.tsukimiya.lib4b.command

import mc.tsukimiya.lib4b.Lib4B
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.command.RemoteConsoleCommandSender
import org.bukkit.entity.Player

interface RestrictSenderTrait {
    fun isRestrictPlayer(): Boolean = false

    fun isRestrictConsole(): Boolean = false

    /**
     * senderがコマンドを実行できるならtrue
     * できないならfalse
     *
     * @param sender
     * @return
     */
    fun testRestriction(sender: CommandSender): Boolean {
        when (sender) {
            is ConsoleCommandSender, is RemoteConsoleCommandSender -> {
                if (isRestrictConsole()) {
                    sender.sendMessage(Lib4B.instance.formatter.formatMessage("command.restrict.console"))
                    return false
                }
                return true
            }

            is Player -> {
                if (isRestrictPlayer()) {
                    sender.sendMessage(Lib4B.instance.formatter.formatMessage("command.restrict.player"))
                    return false
                }
                return true
            }

            else -> return true
        }
    }
}
