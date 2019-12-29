package core.shortcuts

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed

class Embed(
    var title: String? = null,
    var description: String? = null,
    var color: java.awt.Color? = null,
    var image: String? = null
) {

    fun build(): EmbedBuilder {
        var embed = EmbedBuilder()

        embed.setTitle(title)
        embed.setDescription(description)
        embed.setColor(color)
        embed.setImage(image)

        return embed
    }

}

fun embed(dsl: Embed.() -> Unit): MessageEmbed {
    return Embed().apply(dsl).build().build()

}

