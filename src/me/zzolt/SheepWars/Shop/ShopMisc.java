package me.zZolt.SheepWars.Shop;

import java.io.File;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class ShopMisc {
	
	File quickBuy = new File("plugins/SheepWars/quickbuy.yml");
	
	Config config = new Config(quickBuy);
	
	String[] items = {"Stone Sword", "Iron Sword", "Diamond Sword", "Wood Axe"};
	
	public void assignConfig(Player player) {
		
		if(!config.exists(player.getName())) {
			
			
		}
		
	}

	public int calculateDye(Player player) {
		
		int amount = 0;
		
		for(Item item : player.getInventory().getContents().values()) {
			
			
			if(item.getId() == (Item.DYE)) {
				
				amount+= item.count;
				
				
			}
			
		}
		
		return amount;
		
	}

	public int calculateDiamonds(Player player) {
	
		int amount = 0;
	
		for(Item item : player.getInventory().getContents().values()) {
		
		
			if(item.getId() == (Item.DIAMOND)) {
			
			amount+= item.count;
			
			
			}
		
	}
	
	return amount;
	
}

	public void buyItem(Player player, int item, int color, int cost, int amount, Boolean isDye, Boolean stackable, Boolean colored, int color2) {
		
		if(isDye) {
		
		if(player.getInventory().contains(new Item(Item.DYE, color, cost))) {
			
			for(int i = 0; i < cost; i++) {
				
				player.getInventory().removeItem(new Item[] { new Item(Item.DYE, color) });
				
				}
			
			if(stackable) {
				
				if(colored) {
				
					player.getInventory().addItem(new Item(item, color2, amount));
				
				} else {
					
					player.getInventory().addItem(new Item(item, 0, amount));
					
				}
				
			} else {
				
					int slot = player.getInventory().firstEmpty(null);
				
					player.getInventory().setItem(slot, new Item(item));
				
			}
			
		} else {
			
			player.sendMessage("Not enough dye.");
			
		}
		
	} else {
		
		if(player.getInventory().contains(new Item(Item.DIAMOND, 0, 4))) {
			
			
			for(int i = 0; i < cost; i++) {
				
				player.getInventory().removeItem(new Item[] { new Item(Item.DIAMOND) });
				
				}
			
			if(stackable) {
				
				if(colored) {
				
					player.getInventory().addItem(new Item(item, color, amount));
				
				} else {
					
					player.getInventory().addItem(new Item(item, amount));
					
				}
				
			} else {
				
					int slot = player.getInventory().firstEmpty(null);
				
					player.getInventory().setItem(slot, new Item(item));
				
			}
			
		} else {
			
			player.sendMessage("Not enough diamonds.");
			
		}
		
	}
		
		player.getInventory().sendContents(player);
		
	}
	
	public TextFormat canBuy(int amount, int cost) {
		
		if(amount >= cost) {
			
			return TextFormat.GREEN;
			
		} else {
		
			return TextFormat.RED;
		
		}
		
	}
	
}
