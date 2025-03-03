package fr.skhr.oretools.common.item;

import fr.skhr.oretools.OreTools;
import net.minecraft.item.ItemSword;

public class SwordBase extends ItemSword {

	public SwordBase(ToolMaterial toolMaterial, String unlocalizedName) {
		super(toolMaterial);

		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(OreTools.MODID + ":" + unlocalizedName);
		this.setCreativeTab(OreTools.creativeTabs);
	}
}
