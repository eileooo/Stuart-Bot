package core.shortcuts

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color

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

fun String.successEmbed(): MessageEmbed {
    var content = this
    return embed {
        color = Color(17, 255, 0, 200)
        description = content
    }
}

fun String.errorEmbed(): MessageEmbed {
    var content = this
    return embed {
        color = Color.red
        description = content
    }
}