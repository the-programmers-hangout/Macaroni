package me.moeszyslak.polly.preconditions

import me.jakejmattson.discordkt.api.dsl.*
import me.moeszyslak.polly.data.Configuration

fun setupPrecondition(configuration: Configuration) = precondition {
    val guild = guild ?: return@precondition
    val command: Command = command ?: return@precondition

    if (!command.names.contains("Setup")) {
        if (!configuration.hasGuildConfig(guild.id.longValue))
            fail("You must first use the `Setup` command in this guild.")
    }
}
