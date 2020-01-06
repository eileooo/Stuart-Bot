import core.commands.social
import core.configuraton.Loader
import core.framework.Help
import core.framework.Runner
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.Message
import java.io.File
import java.util.*
import kotlin.concurrent.schedule

fun String.after(str: String) = this.split("$str: ")[1]

class Main {

    companion object {
        lateinit var jda: JDA
        lateinit var guild: Guild
        lateinit var user: User
        lateinit var channel: TextChannel
        lateinit var message: Message
        lateinit var help: Help
    }
}

fun main() {
    Loader.setup()
    val lines = File("resources/config.yml").readLines()
    val token = lines[0].after("token")
    val id = lines[1].after("id")
    // val prefix = lines[2].after("prefix")

    Main.jda = JDABuilder(AccountType.BOT).setToken(token).addEventListeners(Runner()).build()
    val jda = Main.jda

    GlobalScope.launch {
        delay(10000)

        println("Run!")

        Main.guild = jda.getGuildById("642474933922037773")!!
        Main.user = jda.getUserById("348847051074830358")!!
        Main.channel = jda.getTextChannelById("661981387225694229")!!

        Main.channel.retrieveMessageById("661981403285553155").queue {
            Main.message = it!!
        }

        delay(1000)
        social()
        Main.help = Help()

        println(Main.help.text)

    }



}
