package me.zZolt.SheepWars.Shop;

import java.util.ArrayList;
import java.util.HashMap;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.passive.EntityVillager;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerInteractEntityEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;

public class Shop implements Listener {
	
	HashMap<Player, Boolean> stone_sword = new HashMap<>();
	
	ShopMisc shopMisc = new ShopMisc();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		shopMisc.assignConfig(player);
		
	}

	@EventHandler
	public void openShop(PlayerInteractEntityEvent event) {
		
		Player player = event.getPlayer();
		Entity entity = event.getEntity();
		
		if(entity instanceof EntityVillager) {
			
			event.setCancelled(true);
			showShopForm(player);
			
		}
		
	}
	
	@EventHandler
	public void onRespond(PlayerFormRespondedEvent event) {
		
		Player player = event.getPlayer();
		FormWindowSimple window = (FormWindowSimple) event.getWindow();
		
		if(window.getResponse().getClickedButton().getText() == "Back") {
			
			showShopForm(player);
			
		}
		
		if(window.getResponse().getClickedButton().getText() == "Quick Buy") {
			
			showQuickBuyForm(player);
			
		}
		
		if(window.getResponse().getClickedButton().getText() == "Combat") {
			
			showCombatForm(player);
			
		}
		
		if(window.getResponse().getClickedButton().getText() == "Blocks") {
			
			showBlocksForm(player);
			
		}
		
		if(window.getResponse().getClickedButton().getText() == "Tools") {
			
			showToolsForm(player);
			
		}
		
		if(window.getResponse().getClickedButton().getText() == "Other") {
			
			showOtherForm(player);
			
		}
		
		if(window.getResponse().getClickedButton().getText() == "Edit") {
			
			showQuickBuyEditForm(player);
			
		}
		
		
	}
	
	public void showShopForm(Player player) {
		
		ArrayList<ElementButton> buttons = new ArrayList<>();
		buttons.add(new ElementButton("Quick Buy"));
		buttons.add(new ElementButton("Combat"));
		buttons.add(new ElementButton("Blocks"));
		buttons.add(new ElementButton("Tools"));
		buttons.add(new ElementButton("Other"));
		
		int amount = shopMisc.calculateDye(player);
		int diamonds = shopMisc.calculateDiamonds(player);
		
		FormWindowSimple window = new FormWindowSimple("Shop", "Dye: " + amount + "\nDiamonds: " + diamonds, buttons);
		
		player.showFormWindow(window);
		
	}
	
	public void showQuickBuyForm(Player player) {
		
		shopMisc.config.reload();
		
		int amount = shopMisc.calculateDye(player);
		int diamonds = shopMisc.calculateDiamonds(player);
		
		ConfigSection section = shopMisc.config.getSection(player.getName());
		boolean stone = section.getBoolean("0");
		boolean iron = section.getBoolean("1");
		boolean diamond = section.getBoolean("2");
		ArrayList<ElementButton> buttons = new ArrayList<>();
		if(stone) {
			buttons.add(new ElementButton(TextFormat.BOLD + "Stone Sword\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 4) + "4 Dye"));	
		}
		if(iron) {
			buttons.add(new ElementButton(TextFormat.BOLD + "Iron Sword\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 8) + "8 Dye"));	
		}
		if(diamond) {
			buttons.add(new ElementButton(TextFormat.BOLD + "Diamond Sword\n" + TextFormat.RESET + "" + shopMisc.canBuy(diamonds, 4) + "4 Diamonds"));	
		}
		buttons.add(new ElementButton("Edit"));
		buttons.add(new ElementButton("Back"));
		
		FormWindowSimple window = new FormWindowSimple("Quick Buy", "Dye: " + amount + "\nDiamonds: " + diamonds, buttons);
		
		player.showFormWindow(window);
		
	}
	
	public void showQuickBuyEditForm(Player player) {
		
		shopMisc.config.reload();
		
		ArrayList<Element> elements = new ArrayList<>();
		
		ConfigSection section = shopMisc.config.getSection(player.getName());
		
		for(int i = 0; i < shopMisc.items.length; i++) {
			
			elements.add(new ElementToggle(shopMisc.items[i], section.getBoolean(shopMisc.items[i])));
			
		}
		
		FormWindowCustom window = new FormWindowCustom("Edit Quick Buy", elements);
		
		player.showFormWindow(window);
		
	}
	
	public void showCombatForm(Player player) {
		
		int amount = shopMisc.calculateDye(player);
		int diamonds = shopMisc.calculateDiamonds(player);
		
		ArrayList<ElementButton> buttons = new ArrayList<>();
		buttons.add(new ElementButton(TextFormat.BOLD + "Stone Sword\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 4) + "4 Dye"));
		buttons.add(new ElementButton(TextFormat.BOLD + "Iron Sword\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 8) + "8 Dye"));
		buttons.add(new ElementButton(TextFormat.BOLD + "Diamond Sword\n" + TextFormat.RESET + "" + shopMisc.canBuy(diamonds, 4) + "4 Diamonds"));
		buttons.add(new ElementButton("Back"));
		
		FormWindowSimple window = new FormWindowSimple("Combat", "Dye: " + amount + "\nDiamonds: " + diamonds, buttons);
		
		player.showFormWindow(window);
		
	}
	
	public void showBlocksForm(Player player) {
		
		int amount = shopMisc.calculateDye(player);
		int diamonds = shopMisc.calculateDiamonds(player);
		
		ArrayList<ElementButton> buttons = new ArrayList<>();
		buttons.add(new ElementButton(TextFormat.BOLD + "16 Wool\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 4) + "4 Dye"));
		buttons.add(new ElementButton(TextFormat.BOLD + "16 Concrete\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 8) + "8 Dye"));
		buttons.add(new ElementButton(TextFormat.BOLD + "16 Wood\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 8) + "8 Dye"));
		buttons.add(new ElementButton("Back"));
		
		FormWindowSimple window = new FormWindowSimple("Blocks", "Dye: " + amount + "\nDiamonds: " + diamonds, buttons);
		
		player.showFormWindow(window);
		
	}

	public void showToolsForm(Player player) {
	
	int amount = shopMisc.calculateDye(player);
	int diamonds = shopMisc.calculateDiamonds(player);
	
	ArrayList<ElementButton> buttons = new ArrayList<>();
	buttons.add(new ElementButton(TextFormat.BOLD + "Wood Pickaxe\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 4) + "4 Dye"));
	buttons.add(new ElementButton(TextFormat.BOLD + "Stone Pickaxe\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 8) + "8 Dye"));
	buttons.add(new ElementButton(TextFormat.BOLD + "Wood Axe\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 4) + "4 Dye"));
	buttons.add(new ElementButton(TextFormat.BOLD + "Stone Axe\n" + TextFormat.RESET + "" + shopMisc.canBuy(amount, 8) + "8 Dye"));
	buttons.add(new ElementButton("Back"));
	
	FormWindowSimple window = new FormWindowSimple("Tools", "Dye: " + amount + "\nDiamonds: " + diamonds, buttons);
	
	player.showFormWindow(window);
	
	}

	public void showOtherForm(Player player) {
		
		int amount = shopMisc.calculateDye(player);
		int diamonds = shopMisc.calculateDiamonds(player);
		
		ArrayList<ElementButton> buttons = new ArrayList<>();
		buttons.add(new ElementButton(TextFormat.BOLD + "Ender Pearl\n" + TextFormat.RESET + "" + shopMisc.canBuy(diamonds, 4) + "4 Diamonds"));
		buttons.add(new ElementButton(TextFormat.BOLD + "Golden Apple\n" + TextFormat.RESET + "" + shopMisc.canBuy(diamonds, 4) + "4 Diamonds"));
		buttons.add(new ElementButton(TextFormat.BOLD + "Player Tracker\n" + TextFormat.RESET + "" + shopMisc.canBuy(diamonds, 4) + "4 Diamonds"));
		buttons.add(new ElementButton("Back"));
		
		FormWindowSimple window = new FormWindowSimple("Other", "Dye: " + amount + "\nDiamonds: " + diamonds, buttons);
		
		player.showFormWindow(window);
		
	}
	
}
