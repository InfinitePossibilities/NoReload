package com.infiniteone.tasks;

import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class MetricsTask implements Runnable {
  
  private final JavaPlugin plugin;
  
  public MetricsTask(JavaPlugin plugin) {
    this.plugin = plugin;
  }

  public void run() {
    try {
    	Metrics metrics = new Metrics(this.plugin);
    	metrics.start();
    	this.plugin.getLogger().log(Level.INFO, "Metrics started: http://mcstats.org/plugin/NoReload");
    	} 	
    	catch (IOException e) {
    	this.plugin.getLogger().log(Level.WARNING, "Failed to start Metrics.");
    	e.printStackTrace();
    }
  }
}