package core.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import core.shortcuts.embed
import java.awt.Color


class Invite : Command() {

    init {
        name = "convite"
        aliases = arrayOf("invite", "suporte", "support")
        help = "Receba o convite para entrar no meu servidor oficial."
    }

    override fun execute(event: CommandEvent?) {
        event!!.reply(embed {
            color = Color.CYAN
            description = """
                Clique [**aqui**](https://discord.gg/ZGMvgP) para entrar no meu servidor oficial!
            """.trimIndent()
        })
    }


}