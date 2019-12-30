package core.framework

import net.dv8tion.jda.api.entities.*
import net.dv8tion.jda.api.requests.restaction.MessageAction

class Container(
    var message: Message,
    var args: List<String>,
    var channel: MessageChannel,
    var guild: Guild,
    var author: User,
    var member: Member
) {

    fun reply(anwser: String) = channel.sendMessage(anwser).queue()
    fun reply(anwser: MessageEmbed): Message? {
        var message: Message? = null
        channel.sendMessage(anwser).queue()
        channel.sendMessage(anwser).queue {
            message = it
        }

        return message
    }

}

fun Container.require(requirement: Any, content: String): Any? {
    when (requirement) {
        //is User -> this.user(content)
        else -> return null
    }
}

private fun Container.user(index: Int, required: Int): User? {
    var id = this.guild.getMemberById(this.args[index])

    /*if (id == null) {
        if ()
    } else return id.user*/

    return null
}