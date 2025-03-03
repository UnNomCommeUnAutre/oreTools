package fr.skhr.oretools.common.item;

import fr.skhr.oretools.OreTools;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ArmorBase extends ItemArmor {

	public ArmorBase(ArmorMaterial armorMaterial,  int type, String unlocalizedName) {
		super(armorMaterial, 0, type);
		
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(OreTools.MODID + ":" + unlocalizedName);
		this.setCreativeTab(OreTools.creativeTabs);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
		String armorName = this.getArmorMaterial().name().replace("Armor", "");
        if(slot == 2)
        {
            return OreTools.MODID + ":textures/models/armor/" + armorName + "_layer_2.png";
        }
        return OreTools.MODID + ":textures/models/armor/" + armorName + "_layer_1.png";
    }
}
