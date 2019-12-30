package core.commands

import core.framework.Command
import core.framework.Container
import core.shortcuts.successEmbed
import net.dv8tion.jda.api.Permission

class Ping : Command() {

    override var label: String = "ping"
    override var aliases: List<String> = listOf()
    override var description: String = "Acho que não precisa de descrição..."
    override var permissions: List<Permission> = listOf()

    override fun run(container: Container) {
        container.channel.sendMessage("Pong").queue()
    }


}