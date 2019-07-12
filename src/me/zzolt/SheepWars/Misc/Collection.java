package me.zZolt.SheepWars.Misc;

import java.util.Random;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockWool;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerInteractEvent.Action;
import cn.nukkit.item.Item;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.BlockColor;
import cn.nukkit.utils.DyeColor;

public class Collection implements Listener {
	
	/*
	 * 
	 * This is for the mining shit where u get dye from wool
	 * 
	 */
	
	PluginBase plugin;
	
	@EventHandler
	public void onShear(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		BlockWool block = (BlockWool) event.getBlock();
		DyeColor dye = block.getDyeColor();
		
		if(player.getInventory().getItemInHand().getId() == Item.SHEARS && action == Action.RIGHT_CLICK_BLOCK && block.getId() == Block.WOOL && dye.getColor() != BlockColor.WHITE_BLOCK_COLOR) {
			
			player.getLevel().setBlockAt((int) block.x, (int) block.y, (int) block.z, Block.WOOL);
			player.getLevel().addSound(new Vector3(player.x, player.y, player.z), Sound.MOB_SHEEP_SHEAR);
			
			if(dye.getColor() == BlockColor.LIME_BLOCK_COLOR) {
				
				player.getInventory().addItem(new Item(Item.DYE, 10));
				
				
			}
			
			Random rand = new Random();
			
			new NukkitRunnable()
			{
				
			    @Override
			    public void run()
			    {
			    	
			    	player.getLevel().setBlockAt((int) block.x, (int) block.y, (int) block.z, Block.WOOL, (short) 5);
			    	
			    }
			}.runTaskLater(plugin, (rand.nextInt(10)*20) + (10*20));
			
		}
		
	}

}
