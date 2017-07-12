package com.infiniteone.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NoReloadCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		
	    if (label.equalsIgnoreCase("noreload")) {
	    	if (player.hasPermission("noreload.*") || (player.hasPermission("noreload.help"))) {
	    		{if (args.length == 0) { // Handles the /noreload command
	    			player.sendMessage(ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH + "----------------");
	    			player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "NoReload" + ChatColor.RESET + "" + ChatColor.YELLOW + " by InfiniteOne");
	    			player.sendMessage(ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH + "----------------");
	    			player.sendMessage(ChatColor.YELLOW + "/noreload help -- Shows this message");
	    			player.sendMessage(ChatColor.YELLOW + "/reload -- Does nothing ;)");
	    			return true;
	    		}
	    			else {
	    				if (args[0].equalsIgnoreCase("help")) { //Handles the /noreload help command
	    					player.sendMessage(ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH + "----------------");
	    					player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "NoReload" + ChatColor.RESET + "" + ChatColor.YELLOW + " by InfiniteOne");
	    					player.sendMessage(ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH + "----------------");
	    					player.sendMessage(ChatColor.YELLOW + "/noreload help -- Shows this message");
	    					player.sendMessage(ChatColor.YELLOW + "/reload -- Does nothing ;)");
	    					return true;
	    				}
	    			}
	    		}
	    	}
	    }
	    return true;
	}
}