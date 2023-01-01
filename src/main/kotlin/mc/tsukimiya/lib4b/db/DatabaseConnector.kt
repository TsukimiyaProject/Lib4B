package mc.tsukimiya.lib4b.db

import mc.tsukimiya.lib4b.db.exception.ConfigNotFoundKeyException
import mc.tsukimiya.lib4b.db.exception.InvalidConfigValueException
import org.bukkit.configuration.file.FileConfiguration
import org.jetbrains.exposed.sql.Database
import java.io.File

object DatabaseConnector {
    fun connect(config: FileConfiguration) {
        when (config.getString("db-type")) {
            "sqlite" -> {
                val fileName = config.getString("sqlite.file") ?: throw ConfigNotFoundKeyException("sqlite.file")
                val file = File(fileName)
                if (!file.exists()) {
                    file.createNewFile()
                }
                Database.connect("jdbc:sqlite:${file.path}", "org.sqlite.JDBC")
            }
            "mysql" -> {
                val address = config.getString("mysql.address") ?: throw ConfigNotFoundKeyException("mysql.address")
                val port = config.getInt("mysql.port", 0)
                    .let { if (it == 0) throw ConfigNotFoundKeyException("mysql.port") else it }
                val db = config.getString("mysql.database") ?: throw ConfigNotFoundKeyException("mysql.database")
                val user = config.getString("mysql.user") ?: throw ConfigNotFoundKeyException("mysql.user")
                val password = config.getString("mysql.password") ?: throw ConfigNotFoundKeyException("mysql.password")
                Database.connect("jdbc:mysql://${address}:${port}/$db", "com.mysql.jdbc.Driver", user, password)
            }
            else -> throw InvalidConfigValueException("db-type", config.getString("db-type") ?: "")
        }
    }
}
