package fr.skhr.oretools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OreToolsCreativeTab extends CreativeTabs{
	public OreToolsCreativeTab() {
		super("OreTools");
	}

	@Override
	public Item getTabIconItem() {
		return OreTools.itemSapphire;
	}
}
