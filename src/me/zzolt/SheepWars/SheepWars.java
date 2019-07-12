package me.zZolt.SheepWars;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import me.zZolt.SheepWars.Misc.Collection;
import me.zZolt.SheepWars.Shop.Shop;
import me.zZolt.SheepWars.Shop.ShopQuickBuy;
import me.zZolt.SheepWars.Shop.ShopItems;
import me.zZolt.SheepWars.Shop.ShopMisc;

public class SheepWars extends PluginBase {
	
	ShopMisc shopMisc = new ShopMisc();
	
	Path pluginDir;
	public static File quickBuy;
	
	@Override
	public void onEnable() {
		
		this.getServer().getLogger().info("SheepWars has Been enabled.\n");
		registerEvents();
		
		pluginDir  = getDataFolder().toPath();
		
		if (Files.notExists(pluginDir)) {
            try {
                Files.createDirectories(pluginDir);
            } catch (IOException e) {
                throw new AssertionError("Could not create directory");
            }
		}
            
        quickBuy = new File("plugins/SheepWars/quickbuy.yml");
        if(!quickBuy.exists()) {
        	try {
        		
        		quickBuy.createNewFile();
        	
        	} catch (IOException e) {
        	
        		throw new AssertionError("Could not create file");
        		
        	}
        	
        }
        
        for(Player player : this.getServer().getOnlinePlayers().values()) {
        	
        	shopMisc.assignConfig(player);
        	
        }
		
	}
	
	@Override
	public void onDisable() {
		
		this.getServer().getLogger().info("SheepWars has Been disabled.\n");
		
	}
	
	public void registerEvents() {
		
		this.getServer().getPluginManager().registerEvents(new Collection(), this);
		this.getServer().getPluginManager().registerEvents(new Shop(), this);
		this.getServer().getPluginManager().registerEvents(new ShopItems(), this);
		this.getServer().getPluginManager().registerEvents(new ShopQuickBuy(), this);
		
	}
	

}
