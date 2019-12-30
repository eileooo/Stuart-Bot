import net.dv8tion.jda.api.entities.MessageChannel

class Command(val label: String, val category: String) {
    private var action: (Command.(Container) -> Unit?)? = null
    private var container: Container? = null

    fun run(info: Container) {
        container = info
        action!!(info!!)
    }

    fun execute(run: (Command.(Container) -> Unit)) {
        action = run
    }

    fun reply(content: String) {
        container!!.channel.sendMessage(content).queue()
    }
}

var commandSets = mutableListOf<CommandSet>()

data class Container(val channel: MessageChannel)

class CommandSet(val category: String) {

    var commands = mutableListOf<Command>()

    inline fun command(label: String, command: Command.() -> Unit) {
        commands.add(Command(label, category))
    }
}

inline fun commands(category: String, create: CommandSet.() -> Unit) {
    val set = CommandSet(category)

    commandSets.add(set)
}

fun socialCommands() = commands("social") {

    command("ping") {
        execute {
            reply("Pong!")
        }
    }

}

fun main() {
    socialCommands()
    println(commandSets)
}