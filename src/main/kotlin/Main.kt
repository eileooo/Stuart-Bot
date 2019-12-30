import core.commands.Ping
import core.commands.Test
import core.configuraton.Loader
import core.framework.Runner
import core.framework.commands
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import java.io.File

fun String.after(str: String) = this.split("$str: ")[1]

fun main() {
    Loader.setup()
    val lines = File("resources/config.yml").readLines()
    val token = lines[0].after("token")
    val id = lines[1].after("id")
    // val prefix = lines[2].after("prefix")

    commands.add(Ping())
    commands.add(Test())
    JDABuilder(AccountType.BOT).setToken(token).addEventListeners(Runner()).build()

}
