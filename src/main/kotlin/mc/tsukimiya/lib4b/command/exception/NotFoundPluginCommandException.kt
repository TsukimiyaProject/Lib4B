package mc.tsukimiya.lib4b.command.exception

import mc.tsukimiya.lib4b.Main

class NotFoundPluginCommandException(command: String, plugin: String) : RuntimeException(
    Main.instance.formatter.formatMessage("command.exception.pl-cmd-not-found", command, plugin)
) {
}
