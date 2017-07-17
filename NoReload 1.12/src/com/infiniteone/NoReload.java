package com.infiniteone;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.infiniteone.cmds.NoReloadCommand;
import com.infiniteone.events.PlayerListener;
import com.infiniteone.tasks.MetricsTask;

public class NoReload extends JavaPlugin {
	
	public static HashMap<String, String> messageData = new HashMap<String, String>();

	FileConfiguration config = getConfig();
	
	public static NoReload plugin;
	
	public void onEnable() {
		
	    getCommand("noreload").setExecutor(new NoReloadCommand());
	    
	    infConfig();
	    
	    infEvents();
	    infMsgs();
	    infMetrics();
	    
		System.out.println("[NoReload] Enabled successfully!");
	}
	
	@Override
	public void onDisable() {
		plugin = null;
		System.out.println("[NoReload] Disabled successfully!");
	}
	
	  private void infConfig() {
		  this.getConfig();
		  saveDefaultConfig();
		  getDataFolder();
	  }
	  
	  private void infEvents() {
		  PluginManager pm = getServer().getPluginManager();
		  pm.registerEvents(new PlayerListener(), this);
	  }
	  
	  private void infMsgs() {
		  File f = new File(getDataFolder()+File.separator+"messages.yml");
	        if (!f.exists()) {
	            try {
	                f.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        setMessage("prefix", "&f[&9NoReload&f] "); // adds to messages.yml
	        setMessage("denied-reload", "&cSorry, this command is dangerous!"); // adds to messages.yml
	        
	        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
	        for (String message : config.getConfigurationSection("").getKeys(false)) {
	            messageData.put(message, config.getString(message));
	        }
		}
	  
	  private void infMetrics()
	  {
	    boolean useMetrics = getConfig().getBoolean("Metrics", true);
	    if (useMetrics)
	      Bukkit.getScheduler().runTask(this, new MetricsTask(this));
	    else
	      getLogger().log(Level.INFO, "Skipping Metrics.");
	  }
	  
	  private void setMessage(String name, String message) {
	        File f = new File(getDataFolder()+File.separator+"messages.yml");
	        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
	        if (!config.isSet(name)) {
	            config.set(name, message);
	            try {
	                config.save(f);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	  }
	  public boolean PluginEnabled = getConfig().getBoolean("Enabled", true);
}
