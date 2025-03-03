package fr.skhr.oretools.common.block;

import fr.skhr.oretools.OreTools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
	public BlockBase(Material material, String unlocalizedName) {
		super(material);

		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(OreTools.MODID + ":" + unlocalizedName);
		this.setCreativeTab(OreTools.creativeTabs);
	}
}
