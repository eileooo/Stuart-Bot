package core.framework

import core.shortcuts.errorEmbed
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

var commands = arrayListOf<Command>()

class Runner : ListenerAdapter() {

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {

        try {

            if (!event.message.contentRaw.startsWith("$")) return
            if (event.author.isBot) return

            val args = event.message.contentRaw.split(" ")
            var filtered = commands.filter { args[0].equals("$${it.label}", true) }

            if (filtered.isEmpty()) return

            filtered.first().run(
                Container(
                    message = event.message,
                    args = args,
                    channel = event.channel,
                    guild = event.guild,
                    author = event.author,
                    member = event.member!!
                )
            )

            return
        } catch (e: Exception) {


            var stack = e.stackTrace[0]

            event.jda.getTextChannelById("661213490249465867")!!.sendMessage("""
                    **Erro**: ${e.message}
                    ```${buildError(e)}```
                """.trimIndent().errorEmbed()).queue()

        }
    }

    fun buildError(e: Exception): String {
        var sb = StringBuilder()

        for (exception in e.stackTrace) {
            sb.append("${exception.methodName} (${exception.className}:${exception.lineNumber})\n")
        }

        return sb.toString()
    }
}