# Lib4B
月宮計画で使いそうなライブラリ詰め合わせセットプラグイン

# コマンドのフレームワーク的な
## 主コマンドクラス
```
import mc.tsukimiya.lib4b.command.BaseCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MoneyCommand : BaseCommand("money") {
    override fun onRun(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val money = 1000
        sender.sendMessage("所持金は${money}円です。")
        return true
    }

    // コンソールからのコマンドを禁止にする
    override fun isRestrictConsole(): Boolean {
        return true
    }
}
```
## サブコマンドクラス
```
import mc.tsukimiya.lib4b.command.BaseSubCommand
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class MoneyShowCommand : BaseSubCommand("show", "/money show <player>", "example.permission.show") {
    override fun onRun(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args == null || args.size < 1) {
            return false
        }
        
        sender.sendMessage(args[0] + "の所持金は〇〇です。")
        
        return true
    }
}

```

## 登録登録
```
import mc.tsukimiya.lib4b.command.CommandRegistrar

~~~

CommandRegistrar(plugin).registerCommand(MoneyCommand(), MoneyShowCommand())
```

## バリデーション
```
import mc.tsukimiya.lib4b.command.Validation

~~~

Validation.isInt(args[0]) // Boolean
```

# メッセージフォーマッター
メッセージ用のコンフィグからメッセージを読み込む  
§の装飾を行ったり変数に代入したり  
変数は%n(n >= 0)、§の代わりに&を使用

```
tsuimiya:
  message:
    example: "&e %0 is %1. &r hahaha."
```
```
import mc.tsukimiya.lib4b.lang.MessageFormatter

~~~

val formatter = MessageFormatter(config)
formatter.formatMessage("tsukimiya.message.example", "true", "false") // §e true is false. §r hahaha.
```
