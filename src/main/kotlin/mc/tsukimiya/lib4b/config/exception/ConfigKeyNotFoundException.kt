package mc.tsukimiya.lib4b.config.exception

import mc.tsukimiya.lib4b.Main

class ConfigKeyNotFoundException(key: String) : RuntimeException(
    Main.instance.formatter.formatMessage("config.key-not-found", key)
)
