package core.shortcuts

import core.framework.Data
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

data class User(val error: String? = null, val user: User? = null)

data class Guild(val error: String? = null, val guild: Guild? = null)


fun Guild.hasUser(id: String) = this.getMemberById(id) != null