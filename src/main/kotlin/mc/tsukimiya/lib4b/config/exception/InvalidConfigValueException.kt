package mc.tsukimiya.lib4b.config.exception

import mc.tsukimiya.lib4b.Lib4B

class InvalidConfigValueException(key: String, value: String) :
    RuntimeException(Lib4B.instance.formatter.formatMessage("config.invalid-value", value, key))
