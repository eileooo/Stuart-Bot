package core.framework

import core.shortcuts.errorEmbed
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Runner : ListenerAdapter() {

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        try {
            if (!event.message.contentRaw.startsWith("$") || event.author.isBot) return
            val args = event.message.contentRaw.split(" ").toMutableList()
            val filtered = sets.first().commands.filter { args[0].equals("$${it.label}", true) }

            args.removeAt(0)

            if (filtered.isNotEmpty()) filtered.first().run(Data(event.channel, event.guild, event.message, event.author, args)) else return
        } catch (ex: ArgumentException) {
            println(ex.error)
            event.channel.sendMessage(ex.error.errorEmbed()).queue()
        }

    }
}