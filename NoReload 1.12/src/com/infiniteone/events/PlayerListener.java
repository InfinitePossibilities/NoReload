package com.infiniteone.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.infiniteone.NoReload;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String prefix = NoReload.messageData.get("prefix");
		Player player = event.getPlayer();// This is to notify me of servers that use my plugin :)
			if(player.getName().equals("InfiniteOne")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix +"&b Hey " + player.getName() + "! NoReload is in use on this server!"));
				return;
		}
	}

	@EventHandler 
	public void onPreProcess(PlayerCommandPreprocessEvent event) {
		String prefix = NoReload.messageData.get("prefix");
		Player player = event.getPlayer();
		if(event.getMessage().equalsIgnoreCase("/reload")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + NoReload.messageData.get("denied-reload")));
		}
	}
}