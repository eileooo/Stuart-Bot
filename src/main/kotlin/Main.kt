import com.jagrosh.jdautilities.command.CommandClientBuilder
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import java.io.File

fun String.after(str: String) = this.split("$str: ")[1]

fun main() {
    val lines = File("resources/config.yml").readLines()
    val token = lines[0].after("token")
    val id = lines[1].after("id")
    val prefix = lines[2].after("prefix")

    var client = CommandClientBuilder()
    client.setOwnerId(id)
    client.setEmojis("\uD83E\uDD29", "⚠", "\uD83D\uDE20")
    client.setPrefix(prefix)

    JDABuilder(AccountType.BOT).setToken(token).addEventListeners(client.build()).build()
}
