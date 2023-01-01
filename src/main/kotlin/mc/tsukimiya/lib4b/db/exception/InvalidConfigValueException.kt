package mc.tsukimiya.lib4b.db.exception

import mc.tsukimiya.lib4b.Main

class InvalidConfigValueException(key: String, value: String) :
    RuntimeException(Main.instance.formatter.formatMessage("config.invalid-value", value, key)) {
}
