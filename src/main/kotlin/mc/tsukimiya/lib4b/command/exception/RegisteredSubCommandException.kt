package mc.tsukimiya.lib4b.command.exception

import mc.tsukimiya.lib4b.Lib4B

class RegisteredSubCommandException(subCommandName: String, parentName: String) : RuntimeException(
    Lib4B.instance.formatter.formatMessage("command.exception.sub-registered", subCommandName, parentName)
)
