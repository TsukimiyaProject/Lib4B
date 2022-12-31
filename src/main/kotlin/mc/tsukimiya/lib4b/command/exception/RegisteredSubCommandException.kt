package mc.tsukimiya.lib4b.command.exception

import mc.tsukimiya.lib4b.Main

class RegisteredSubCommandException(subCommandName: String, parentName: String) : RuntimeException(
    Main.instance.formatter.formatMessage("command.exception.sub-registered", subCommandName, parentName)
) {
}
