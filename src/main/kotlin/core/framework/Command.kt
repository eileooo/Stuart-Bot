package core.framework

import Main
import net.dv8tion.jda.api.entities.*

data class Data(
    var channel: TextChannel, var guild: Guild, var message: Message, var author: User, var arguments: List<String>
)

var jda = Main.jda

class Command(var label: String, category: String) {

    var run: (Command.(/*Data*/) -> Unit)? = null
    var data: Data = Data(
        channel = Main.channel,
        guild = Main.guild,
        message = Main.message,
        author = Main.user,
        arguments = listOf()
    )

    val integer = "integer"

    fun execute(action: Command.(/*Data*/) -> Unit) {
        run = action
    }

    fun run(database: Data) {
        data = database
        run!!(/*data!!*/)
    }

    fun getUserAt(index: Int): User? {
        // get the infos of command
        var context: Data = data

        // verify if the number of arguments is sufficient to run
        if (context.arguments.size < index + 1) return null

        // mention in raw
        var found = context.arguments[index]
        for (user in context.message.mentionedUsers) {
            if (user.asMention == found.replace("!", "")) return user
        }

        // try by id, or the argument is not an user
        return return if (found.toLongOrNull() == null) {
            fail("Usuário não encontrado!")
        } else context.message.jda.getUserById(found.toLong()) ?: fail("Usuário não encontrado!")
    }

    inline fun reply(content: String) = this.data.channel.sendMessage(content).queue()
    inline fun reply(content: MessageEmbed) = this.data.channel.sendMessage(content).queue()

    fun integer(at: Int): Int {
        // verify the number of arguments
        if (this.data.arguments.size < at + 1) return fail("Está faltando argumentos!")

        // try to cast to Int or null
        return this.data.arguments[at].toIntOrNull() ?: fail("``${this.data.arguments[at]}`` não é um número!")
    }

    fun user(at: Int, allowAuthor: Boolean = false): User {
        if (this.data.arguments.size < at + 1) {
            return if (allowAuthor) this.data.author else fail("Está faltando argumentos!")
        }
        return getUserAt(at) ?: fail("Usuário não encontrado!")
    }

    infix fun String.at(at: Int): Int {
        return when {
            this == "integer" -> integer(at)
            else -> 0
        }
    }


}