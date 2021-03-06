package me.moeszyslak.polly.conversations

import com.gitlab.kordlib.core.entity.Guild
import me.jakejmattson.discordkt.api.arguments.*
import me.jakejmattson.discordkt.api.dsl.Conversation
import me.jakejmattson.discordkt.api.dsl.conversation
import me.moeszyslak.polly.data.Configuration
import me.moeszyslak.polly.data.GuildId

fun configurationConversation(guildId: GuildId, configuration: Configuration) = conversation {
    val prefix = promptMessage(EveryArg, "Bot prefix:")
    val log = promptMessage(ChannelArg, "Log channel:")
    val staffRole = promptMessage(RoleArg, "Staff role:")
    val cooldown = promptMessage(TimeArg, "Channel Macro cooldown:")

    configuration.setup(guildId, log, prefix, staffRole, cooldown)
}