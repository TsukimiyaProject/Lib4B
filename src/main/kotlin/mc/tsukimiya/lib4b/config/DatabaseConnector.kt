package mc.tsukimiya.lib4b.config

import mc.tsukimiya.lib4b.config.exception.ConfigKeyNotFoundException
import mc.tsukimiya.lib4b.config.exception.InvalidConfigValueException
import org.bukkit.configuration.file.FileConfiguration
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

abstract class DatabaseConnector {
    fun connect(config: FileConfiguration) {
        var url: String
        var driver: String

        when (val type = config.getString("db-type")) {
            "sqlite" -> {
                val folderName = config.getString("sqlite.folder") ?: throw ConfigKeyNotFoundException("sqlite.folder")
                val fileName = config.getString("sqlite.file") ?: throw ConfigKeyNotFoundException("sqlite.file")
                val file = File(folderName + File.separator + fileName)
                if (!file.exists()) {
                    Files.createDirectories(Paths.get(file.parent))
                    Files.createFile(Paths.get(file.path))
                }

                url = "jdbc:sqlite:${file.path}"
                driver = "org.sqlite.JDBC"
            }

            "mysql" -> {
                val address = config.getString("mysql.address") ?: throw ConfigKeyNotFoundException("mysql.address")
                val port = config.getInt("mysql.port", -1).let {
                    if (it == -1) throw ConfigKeyNotFoundException("mysql.port") else it
                }
                val db = config.getString("mysql.database") ?: throw ConfigKeyNotFoundException("mysql.database")
                val user = config.getString("mysql.user") ?: throw ConfigKeyNotFoundException("mysql.user")
                val password = config.getString("mysql.password") ?: throw ConfigKeyNotFoundException("mysql.password")

                url = "jdbc:mysql://${address}:${port}/${db}?user=${user}&password=${password}"
                driver = "com.mysql.jdbc.Driver"
            }

            else -> throw InvalidConfigValueException("db-type", type ?: "")
        }

        connectDatabase(url, driver)

        createSchema()
    }

    /**
     * Database.connect(url, driver)して
     *
     * @param url
     * @param driver
     */
    abstract fun connectDatabase(url: String, driver: String)

    /**
     * スキーマ作成
     */
    abstract fun createSchema()
}
