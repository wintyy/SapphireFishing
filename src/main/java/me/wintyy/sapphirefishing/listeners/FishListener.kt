package me.wintyy.sapphirefishing.listeners

import me.wintyy.sapphirefishing.utils.ColorUtil
import me.wintyy.sapphirefishing.utils.ConfigUtil
import me.wintyy.sapphirefishing.utils.LootConfigUtil
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerFishEvent

class FishListener : Listener{

    val config = ConfigUtil.getConfig()
    val loot = LootConfigUtil.getConfig()

    @EventHandler
    fun fishCatchEvent(event: PlayerFishEvent) {
        if (event.state == PlayerFishEvent.State.CAUGHT_FISH) {
            var caught = false
            val player: Player = event.player
            for (string: String in loot!!.getKeys(false)) {
                if (!caught) {
                    if (Math.random() < loot.getDouble("$string.chance")) {

                        val item: String = loot.getConfigurationSection("$string.loot-table")!!.getKeys(false).random()



                        caught = true
                        event.isCancelled = true
                        event.hook.remove()
                        if (Math.random() > config!!.getDouble("fail-chance")) {
                            if (config!!.getBoolean("catch-title")) {
                                player.sendTitle(ColorUtil.CC(config.getString("lang.catch-title")!!), ColorUtil.CC(config.getString("lang.catch-subtitle")!!.replace("%item%", ColorUtil.CC(loot.getString("$string.loot-table.$item.display-name")!!)!!))!!)
                                player.sendMessage(ColorUtil.CC(config!!.getString("lang.catch-message")!!.replace("%rarity-color%", loot.getString("$string.color")!!))!!.replace("%rarity%", loot.getString("$string.name")!!))
                            }


                            for (cmd: String in loot.getStringList("$string.loot-table.$item.commands")){
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%player%", player.name))
                            }


                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), loot.getString("$string.loot-table.$item.command")!!.replace("%player%", player.name))

                        } else {
                            if (config!!.getBoolean("fail-title")) {
                                player.sendTitle(ColorUtil.CC(config.getString("lang.fail-title")!!), ColorUtil.CC(config.getString("lang.fail-subtitle")!!))
                                player.sendMessage(ColorUtil.CC(config!!.getString("lang.fail-message")!!.replace("%rarity-color%", loot.getString("$string.color")!!))!!.replace("%rarity%", loot.getString("$string.name")!!))
                            }
                        }

                    }
                }
            }
        }
    }




}