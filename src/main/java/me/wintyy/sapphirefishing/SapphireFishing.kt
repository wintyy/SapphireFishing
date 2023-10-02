package me.wintyy.sapphirefishing

import me.wintyy.sapphirefishing.listeners.FishListener
import me.wintyy.sapphirefishing.utils.ColorUtil
import me.wintyy.sapphirefishing.utils.ConfigUtil
import me.wintyy.sapphirefishing.utils.LootConfigUtil
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class SapphireFishing : JavaPlugin() {
    override fun onEnable() {
        instance = this
        val cs: CommandSender = Bukkit.getConsoleSender()
        ConfigUtil.init()
        cs.sendMessage(ColorUtil.CC("&7[&9SapphireFishing&7] &aLoaded config.yml"))
        LootConfigUtil.init()

        Bukkit.getPluginManager().registerEvents(FishListener(), this)


        cs.sendMessage(ColorUtil.CC("&7[&9SapphireFishing&7] &aLoaded loottable.yml"))
        cs.sendMessage(ColorUtil.CC(""))
        cs.sendMessage(ColorUtil.CC(""))
        cs.sendMessage(ColorUtil.CC(""))
        cs.sendMessage(ColorUtil.CC("&7&m--------------------------------"))
        cs.sendMessage(ColorUtil.CC(""))
        cs.sendMessage(ColorUtil.CC("&9SapphireFishing:"))
        cs.sendMessage(ColorUtil.CC("&fAuthor: &1wintyy"))
        cs.sendMessage(ColorUtil.CC("&fVersion: &1InDev"))
        cs.sendMessage(ColorUtil.CC(""))
        cs.sendMessage(ColorUtil.CC("&fThank you for using our Plugin!"))
        cs.sendMessage(ColorUtil.CC(""))
        cs.sendMessage(ColorUtil.CC("&7&m--------------------------------"))


        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }




    companion object{
        lateinit var instance: SapphireFishing
    }




}
