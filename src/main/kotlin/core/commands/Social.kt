package core.commands

import core.framework.module
import core.shortcuts.embed
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.entities.User

fun social() = module("social") {

    command("ping") {
        execute {
            reply("Pong!")
        }
    }

    command("avatar") {
        execute {
            reply(avatarEmbed(user(0, true)))
        }
    }

    command("number") {
        execute {
            val number = integer(0)
            reply("$number")
        }
    }

    command("botinfo") {
        execute {
            var jda = data.message.jda
            reply(embed {
                title = "Quem sou eu?"
                color = discordColor
                description = """
                    Meu nome é ``Stuart``, fui criado no dia ``31``de ``Dezembro`` de ``2019`` pelo ``Leonardo#0001``. 

                    Estou presente em ``${jda.guilds.size}`` servidores e conheço ``${jda.users.size}`` usuários!  
                """.trimIndent()
            })
            reply("https://discord.gg/y6c6kP8")
        }
    }
}

inline fun avatarEmbed(user: User): MessageEmbed {
    return embed {
        image = user.avatarUrl + "?size=2048"
        color = discordColor
        title = user.name
    }

}

