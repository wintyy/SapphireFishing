package me.wintyy.sapphirefishing.utils

import org.bukkit.configuration.file.FileConfiguration

class LootConfigUtil {

    companion object{
        var configuration: FileConfiguration? = null

        fun getConfig(): FileConfiguration?{
            return configuration
        }

        fun init(){
            configuration = YamlConfigUtil("loottable.yml")
        }
    }
}