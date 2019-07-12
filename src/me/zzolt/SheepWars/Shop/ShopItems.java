package me.zZolt.SheepWars.Shop;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;

public class ShopItems implements Listener {
	
	ShopMisc shopMisc = new ShopMisc();
	
	@EventHandler
	public void onRespond(PlayerFormRespondedEvent event) {
		
		Player player = event.getPlayer();
		FormWindowSimple window = (FormWindowSimple) event.getWindow();
			
		if(window.getResponse().getClickedButton().getText().contains("Stone Sword")) {
			
			shopMisc.buyItem(player, Item.STONE_SWORD, 10, 4, 1, true, false, false, 5);
			
		}

		if(window.getResponse().getClickedButton().getText().contains("Iron Sword")) {
			
			shopMisc.buyItem(player, Item.IRON_SWORD, 10, 8, 1, true, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Diamond Sword")) {
			
			shopMisc.buyItem(player, Item.DIAMOND_SWORD, 10, 4, 1, false, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("16 Wool")) {
			
			shopMisc.buyItem(player, Item.WOOL, 10, 4, 16, true, true, true, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("16 Concrete")) {
			
			shopMisc.buyItem(player, Item.CONCRETE, 10, 8, 16, true, true, true, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("16 Wood")) {
			
			shopMisc.buyItem(player, Item.PLANKS, 10, 8, 16, true, true, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Wood Pickaxe")) {
			
			shopMisc.buyItem(player, Item.WOODEN_PICKAXE, 10, 4, 1, true, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Stone Pickaxe")) {
			
			shopMisc.buyItem(player, Item.STONE_PICKAXE, 10, 8, 1, true, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Wood Axe")) {
			
			shopMisc.buyItem(player, Item.WOODEN_AXE, 10, 4, 1, true, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Stone Axe")) {
			
			shopMisc.buyItem(player, Item.STONE_AXE, 10, 8, 1, true, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Ender Pearl")) {
			
			shopMisc.buyItem(player, Item.ENDER_PEARL, 10, 4, 1, false, false, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Golden Apple")) {
			
			shopMisc.buyItem(player, Item.GOLDEN_APPLE, 10, 4, 1, false, true, false, 5);
			
		}
		
		if(window.getResponse().getClickedButton().getText().contains("Player Tracker")) {
			
			shopMisc.buyItem(player, Item.COMPASS, 10, 4, 1, false, false, false, 5);
			
		}
		
	}

}
