package mc.tsukimiya.lib4b.command.exception

import mc.tsukimiya.lib4b.Lib4B

class NotFoundPluginCommandException(command: String, plugin: String) : RuntimeException(
    Lib4B.instance.formatter.formatMessage("command.exception.pl-cmd-not-found", command, plugin)
)
