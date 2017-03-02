package cc.isotopestudio.evolution.listener;
/*
 * Created by Mars Tan on 3/2/2017.
 * Copyright ISOTOPE Studio
 */

import cc.isotopestudio.evolution.data.PlayerData;
import cc.isotopestudio.evolution.sql.SqlManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        PlayerData.addPlayer(event.getPlayer().getName());
    }
}
