package me.wintyy.sapphirefishing.utils

import me.wintyy.sapphirefishing.SapphireFishing
import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

class YamlConfigUtil(private val file: String) : YamlConfiguration() {
    private var jfile: File? = null

    init {
        jfile = File(SapphireFishing.instance!!.dataFolder, file)
        if (!jfile!!.exists()){
            jfile!!.parentFile.mkdirs()
            SapphireFishing.instance!!.saveResource(file, false)
        }
        try {
            this.load(jfile!!)
        } catch (x: InvalidConfigurationException){
            Bukkit.getConsoleSender().sendMessage(ColorUtil.CC("&4Error while loading ") + file + ":" + x.message + "Caused By: " + x.cause)
        }catch (x: IOException){
            Bukkit.getConsoleSender().sendMessage(ColorUtil.CC("&4Error while loading ") + file + ":" + x.message + "Caused By: " + x.cause)
        }
    }

    public fun save(){
        try {
            this.save(jfile!!)
        } catch (x: IOException){
            Bukkit.getConsoleSender().sendMessage(ColorUtil.CC("&4Error while loading ") + file + ":" + x.message + "Caused By: " + x.cause)
        }
    }

    public fun delete(){
        jfile!!.delete()
    }

    public fun getConfiguration(): ConfigurationSection? {
        return null
    }

}