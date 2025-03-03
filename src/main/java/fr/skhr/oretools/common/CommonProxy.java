package fr.skhr.oretools.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraftforge.common.config.Configuration;

public class CommonProxy {
	public static Configuration config;

	public static Map<String, Integer> blockList = new LinkedHashMap<String, Integer>();
	public static Map<String, Integer> itemList = new LinkedHashMap<String, Integer>();

	public void initConfig() {
		CommonProxy.config.load();
		
		//ID configuration ( Minecraft limit )
		//-Block: 422 > id < 2256 - 2267 > id < 4096
		//-Item: 4096 > id < 32768
		// /!\ Add new block or item to the bottom of their list /!\
		
		//-Block:
		CommonProxy.blockList.put("emerald-tools_ore", 0);
		CommonProxy.blockList.put("ruby_ore", 0);
		CommonProxy.blockList.put("sapphire_ore", 0);
		CommonProxy.blockList.put("cobalt_ore", 0);
		CommonProxy.blockList.put("emerald-tools_block", 0);
		CommonProxy.blockList.put("ruby_block", 0);
		CommonProxy.blockList.put("sapphire_block", 0);
		CommonProxy.blockList.put("cobalt_block", 0);
		CommonProxy.blockList.put("reinforced_cobalt_block", 0);

		int idBlock = 450; //Start id
		for(Entry<String, Integer> block : blockList.entrySet()) {
			CommonProxy.blockList.put(block.getKey(), CommonProxy.config.get("id.blocks", block.getKey(), idBlock).getInt());
			idBlock++;
		}
		
		//-Item:
		CommonProxy.itemList.put("emerald-tools", 0);
		CommonProxy.itemList.put("ruby", 0);
		CommonProxy.itemList.put("sapphire", 0);
		CommonProxy.itemList.put("cobalt", 0);
		CommonProxy.itemList.put("reinforced_cobalt", 0);

		CommonProxy.itemList.put("emerald-tools_helmet", 0);
		CommonProxy.itemList.put("emerald-tools_chestplate", 0);
		CommonProxy.itemList.put("emerald-tools_leggings", 0);
		CommonProxy.itemList.put("emerald-tools_boots", 0);
		CommonProxy.itemList.put("ruby_helmet", 0);
		CommonProxy.itemList.put("ruby_chestplate", 0);
		CommonProxy.itemList.put("ruby_leggings", 0);
		CommonProxy.itemList.put("ruby_boots", 0);
		CommonProxy.itemList.put("sapphire_helmet", 0);
		CommonProxy.itemList.put("sapphire_chestplate", 0);
		CommonProxy.itemList.put("sapphire_leggings", 0);
		CommonProxy.itemList.put("sapphire_boots", 0);
		CommonProxy.itemList.put("cobalt_helmet", 0);
		CommonProxy.itemList.put("cobalt_chestplate", 0);
		CommonProxy.itemList.put("cobalt_leggings", 0);
		CommonProxy.itemList.put("cobalt_boots", 0);
		CommonProxy.itemList.put("reinforced_cobalt_helmet", 0);
		CommonProxy.itemList.put("reinforced_cobalt_chestplate", 0);
		CommonProxy.itemList.put("reinforced_cobalt_leggings", 0);
		CommonProxy.itemList.put("reinforced_cobalt_boots", 0);

		CommonProxy.itemList.put("emerald-tools_sword", 0);
		CommonProxy.itemList.put("emerald-tools_pickaxe", 0);
		CommonProxy.itemList.put("emerald-tools_axe", 0);
		CommonProxy.itemList.put("emerald-tools_shovel", 0);
		CommonProxy.itemList.put("emerald-tools_hoe", 0);
		CommonProxy.itemList.put("ruby_sword", 0);
		CommonProxy.itemList.put("ruby_pickaxe", 0);
		CommonProxy.itemList.put("ruby_axe", 0);
		CommonProxy.itemList.put("ruby_shovel", 0);
		CommonProxy.itemList.put("ruby_hoe", 0);
		CommonProxy.itemList.put("sapphire_sword", 0);
		CommonProxy.itemList.put("sapphire_pickaxe", 0);
		CommonProxy.itemList.put("sapphire_axe", 0);
		CommonProxy.itemList.put("sapphire_shovel", 0);
		CommonProxy.itemList.put("sapphire_hoe", 0);
		CommonProxy.itemList.put("cobalt_sword", 0);
		CommonProxy.itemList.put("cobalt_pickaxe", 0);
		CommonProxy.itemList.put("cobalt_axe", 0);
		CommonProxy.itemList.put("cobalt_shovel", 0);
		CommonProxy.itemList.put("cobalt_hoe", 0);
		CommonProxy.itemList.put("reinforced_cobalt_sword", 0);
		CommonProxy.itemList.put("reinforced_cobalt_pickaxe", 0);
		CommonProxy.itemList.put("reinforced_cobalt_axe", 0);
		CommonProxy.itemList.put("reinforced_cobalt_shovel", 0);
		CommonProxy.itemList.put("reinforced_cobalt_hoe", 0);
		
		List<Integer> idList = new ArrayList();
		
		int idItem = 4100; //Start id
		for(Entry<String, Integer> item : itemList.entrySet()) {
			item.setValue(CommonProxy.config.get("id.items", item.getKey(), idItem).getInt());
			idList.add(idItem);
			idItem++;
			while(idList.contains(idItem)) {
				idItem++;
			}
		}
		
		CommonProxy.config.save();
	}
}
