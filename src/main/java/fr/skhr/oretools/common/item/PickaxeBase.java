package fr.skhr.oretools.common.item;

import fr.skhr.oretools.OreTools;
import net.minecraft.item.ItemPickaxe;

public class PickaxeBase extends ItemPickaxe {

	public PickaxeBase(ToolMaterial toolMaterial, String unlocalizedName) {
		super(toolMaterial);

		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(OreTools.MODID + ":" + unlocalizedName);
		this.setCreativeTab(OreTools.creativeTabs);
	}
}
