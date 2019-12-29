import com.jagrosh.jdautilities.command.CommandClientBuilder
import core.commands.Invite
import core.configuraton.Loader
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import java.io.File

fun String.after(str: String) = this.split("$str: ")[1]

fun main() {
    Loader.setup()
    val lines = File("resources/config.yml").readLines()
    val token = lines[0].after("token")
    val id = lines[1].after("id")
    val prefix = lines[2].after("prefix")

    var client = CommandClientBuilder()
    client.setOwnerId(id)
    client.setEmojis("\uD83E\uDD29", "⚠", "\uD83D\uDE20")
    client.setPrefix(prefix)
    client.setActivity(Activity.listening("Lofi beats"))
    client.addCommand(Invite())
    JDABuilder(AccountType.BOT). setToken(token).addEventListeners(client.build()).build()

    Loader.br.forEach { (index, value) ->
        println("$index:$value")
    }
}
