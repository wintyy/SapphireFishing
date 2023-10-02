package me.wintyy.sapphirefishing.utils

import net.md_5.bungee.api.ChatColor
import java.util.regex.Pattern

class ColorUtil {

    companion object {
        private val pattern = Pattern.compile("#[a-fA-F0-9]{6}")

        fun CC(message: String): String? {
            var message = message
            var matcher = pattern.matcher(message)
            while (matcher.find()) {
                val color = message.substring(matcher.start(), matcher.end())
                message = message.replace(color, ChatColor.of(color).toString() + "")
                matcher = pattern.matcher(message)
            }
            return ChatColor.translateAlternateColorCodes('&', message)
        }

        fun CC(messages: List<String>): List<String>? {
            val formatted: MutableList<String> = ArrayList()
            for (originalMessage in messages) {
                var message = originalMessage
                var matcher = pattern.matcher(message)
                while (matcher.find()) {
                    val color = message.substring(matcher.start(), matcher.end())
                    message = message.replace(color, ChatColor.of(color).toString() + "")
                    matcher = pattern.matcher(message)
                }
                formatted.add(ChatColor.translateAlternateColorCodes('&', message))
            }
            return formatted
        }
    }
}