package core.framework

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.requests.restaction.MessageAction

abstract class Command {

    abstract var label: String
    abstract var aliases: List<String>
    abstract var description: String
    abstract var permissions: List<Permission>

    abstract fun run(container: Container)

    fun Message.then(func: (Message) -> MessageAction) {
        func(this).queue()
    }
}