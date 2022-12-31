package mc.tsukimiya.lib4b.lang

enum class MessagePrefix(val search: String, val replace: String) {
    /**
     * 情報を表示する時
     * プレイヤーが意図してその情報を求めた場合に使う
     * /moneyで所持金表示とか
     */
    INFO("%INFO%", "[INFO]"),

    /**
     * 情報を表示する時
     * プレイヤーが意図せずその情報を表示される時
     * 再起動まであと何分みたいな
     */
    NOTICE("%NOTICE%", "&a[NOTICE]&f"),

    /**
     * コマンド等の実行に成功した時
     * ワープとか土地保護とか
     */
    SUCCESS("%SUCCESS%", "&b[SUCCESS]&f"),

    /**
     * システム・ルール等で禁止の行為をした場合とか
     * 人の土地に触ったりとか
     */
    WARNING("%WARNING%", "&e[WARNING]&f"),

    /**
     * エラーの時
     */
    ERROR("%ERROR%", "&c[ERROR]&f")
}
