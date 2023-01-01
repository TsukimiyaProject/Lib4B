package mc.tsukimiya.lib4b.db.exception

import mc.tsukimiya.lib4b.Main

class ConfigNotFoundKeyException(key: String) : RuntimeException(
    Main.instance.formatter.formatMessage("config.not-found-key", key)
) {
}
