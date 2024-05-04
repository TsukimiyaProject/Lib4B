package mc.tsukimiya.lib4b.config.exception

import mc.tsukimiya.lib4b.Lib4B

class ConfigKeyNotFoundException(key: String) : RuntimeException(
    Lib4B.instance.formatter.formatMessage("config.key-not-found", key)
)
