package fr.skhr.oretools;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.skhr.oretools.common.CommonProxy;
import fr.skhr.oretools.common.block.BlockBase;
import fr.skhr.oretools.common.item.ArmorBase;
import fr.skhr.oretools.common.item.AxeBase;
import fr.skhr.oretools.common.item.HoeBase;
import fr.skhr.oretools.common.item.ItemBase;
import fr.skhr.oretools.common.item.PickaxeBase;
import fr.skhr.oretools.common.item.ShovelBase;
import fr.skhr.oretools.common.item.SwordBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "oretools", name = "Ore Tools", version = "1.0")
public class OreTools {
	public static final String MODID = "oretools";
	
	@Instance(OreTools.MODID)
	public static OreTools instance;
	
	@SidedProxy(clientSide = "fr.skhr.oretools.client.ClientProxy", serverSide = "fr.skhr.oretools.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs creativeTabs = new OreToolsCreativeTab();
	
	//Reistry
	//-Tool:
	public static ToolMaterial toolEmerald = EnumHelper.addToolMaterial("emerald-tools", 3, 1650, 8.0F, 4.0F, 10);
	public static ToolMaterial toolRuby = EnumHelper.addToolMaterial("ruby", 3, 1750, 8.0F, 5.0F, 10);
	public static ToolMaterial toolSapphire = EnumHelper.addToolMaterial("sapphire", 3, 1850, 8.0F, 6.0F, 10);
	public static ToolMaterial toolCobalt = EnumHelper.addToolMaterial("cobalt", 3, 2100, 8.0F, 7.5F, 10);
	public static ToolMaterial toolReinforcedCobalt = EnumHelper.addToolMaterial("reinforced_cobalt", 3, 2400, 8.0F, 10.0F, 10);
	
	//-Armor:
	public static ArmorMaterial armorEmerald = EnumHelper.addArmorMaterial("emerald-tools", 35, new int[]{4, 8, 7, 4}, 20);
	public static ArmorMaterial armorRuby = EnumHelper.addArmorMaterial("ruby", 38, new int[] {5, 10, 8, 5}, 20);
	public static ArmorMaterial armorSapphire = EnumHelper.addArmorMaterial("sapphire", 44, new int[] {7, 10, 9, 8}, 20);
	public static ArmorMaterial armorCobalt = EnumHelper.addArmorMaterial("cobalt", 50, new int[] {10, 12, 11, 10}, 20);
	public static ArmorMaterial armorReinforcedCobalt = EnumHelper.addArmorMaterial("reinforced_cobalt", 60, new int[] {13, 15, 14, 16}, 20);

	//-Item:
	public static Item itemEmerald = new ItemBase("emerald-tools");
	public static Item itemRuby = new ItemBase("ruby");
	public static Item itemSapphire = new ItemBase("sapphire");
	public static Item itemCobalt = new ItemBase("cobalt");
	public static Item itemReinforcedCobalt = new ItemBase("reinforced_cobalt");

	public static Item itemEmeraldHelmet = new ArmorBase(OreTools.armorEmerald, 0, "emerald-tools_helmet");
	public static Item itemEmeraldChestplate = new ArmorBase(OreTools.armorEmerald, 1, "emerald-tools_chestplate");
	public static Item itemEmeraldLeggings = new ArmorBase(OreTools.armorEmerald, 2, "emerald-tools_leggings");
	public static Item itemEmeraldBoots = new ArmorBase(OreTools.armorEmerald, 3, "emerald-tools_boots");
	public static Item itemRubyHelmet = new ArmorBase(OreTools.armorRuby, 0, "ruby_helmet");
	public static Item itemRubyChestplate = new ArmorBase(OreTools.armorRuby, 1, "ruby_chestplate");
	public static Item itemRubyLeggings = new ArmorBase(OreTools.armorRuby, 2, "ruby_leggings");
	public static Item itemRubyBoots = new ArmorBase(OreTools.armorRuby, 3, "ruby_boots");
	public static Item itemSapphireHelmet = new ArmorBase(OreTools.armorSapphire, 0, "sapphire_helmet");
	public static Item itemSapphireChestplate = new ArmorBase(OreTools.armorSapphire, 1, "sapphire_chestplate");
	public static Item itemSapphireLeggings = new ArmorBase(OreTools.armorSapphire, 2, "sapphire_leggings");
	public static Item itemSapphireBoots = new ArmorBase(OreTools.armorSapphire, 3, "sapphire_boots");
	public static Item itemCobaltHelmet = new ArmorBase(OreTools.armorCobalt, 0, "cobalt_helmet");
	public static Item itemCobaltChestplate = new ArmorBase(OreTools.armorCobalt, 1, "cobalt_chestplate");
	public static Item itemCobaltLeggings = new ArmorBase(OreTools.armorCobalt, 2, "cobalt_leggings");
	public static Item itemCobaltBoots = new ArmorBase(OreTools.armorCobalt, 3, "cobalt_boots");
	public static Item itemReinforcedCobaltHelmet = new ArmorBase(OreTools.armorReinforcedCobalt, 0, "reinforced_cobalt_helmet");
	public static Item itemReinforcedCobaltChestplate = new ArmorBase(OreTools.armorReinforcedCobalt, 1, "reinforced_cobalt_chestplate");
	public static Item itemReinforcedCobaltLeggings = new ArmorBase(OreTools.armorReinforcedCobalt, 2, "reinforced_cobalt_leggings");
	public static Item itemReinforcedCobaltBoots = new ArmorBase(OreTools.armorReinforcedCobalt, 3, "reinforced_cobalt_boots");

	public static Item itemEmeraldSword = new SwordBase(OreTools.toolEmerald, "emerald-tools_sword");
	public static Item itemEmeraldPickaxe = new PickaxeBase(OreTools.toolEmerald, "emerald-tools_pickaxe");
	public static Item itemEmeraldAxe = new AxeBase(OreTools.toolEmerald, "emerald-tools_axe");
	public static Item itemEmeraldShovel = new ShovelBase(OreTools.toolEmerald, "emerald-tools_shovel");
	public static Item itemEmeraldHoe = new HoeBase(OreTools.toolEmerald, "emerald-tools_hoe");
	public static Item itemRubySword = new SwordBase(OreTools.toolRuby, "ruby_sword");
	public static Item itemRubyPickaxe = new PickaxeBase(OreTools.toolRuby, "ruby_pickaxe");
	public static Item itemRubyAxe = new AxeBase(OreTools.toolRuby, "ruby_axe");
	public static Item itemRubyShovel = new ShovelBase(OreTools.toolRuby, "ruby_shovel");
	public static Item itemRubyHoe = new HoeBase(OreTools.toolRuby, "ruby_hoe");
	public static Item itemSapphireSword = new SwordBase(OreTools.toolSapphire, "sapphire_sword");
	public static Item itemSapphirePickaxe = new PickaxeBase(OreTools.toolSapphire, "sapphire_pickaxe");
	public static Item itemSapphireAxe = new AxeBase(OreTools.toolSapphire, "sapphire_axe");
	public static Item itemSapphireShovel = new ShovelBase(OreTools.toolSapphire, "sapphire_shovel");
	public static Item itemSapphireHoe = new HoeBase(OreTools.toolSapphire, "sapphire_hoe");
	public static Item itemCobaltSword = new SwordBase(OreTools.toolCobalt, "cobalt_sword");
	public static Item itemCobaltPickaxe = new PickaxeBase(OreTools.toolCobalt, "cobalt_pickaxe");
	public static Item itemCobaltAxe = new AxeBase(OreTools.toolCobalt, "cobalt_axe");
	public static Item itemCobaltShovel = new ShovelBase(OreTools.toolCobalt, "cobalt_shovel");
	public static Item itemCobaltHoe = new HoeBase(OreTools.toolCobalt, "cobalt_hoe");
	public static Item itemReinforcedCobaltSword = new SwordBase(OreTools.toolReinforcedCobalt, "reinforced_cobalt_sword");
	public static Item itemReinforcedCobaltPickaxe = new PickaxeBase(OreTools.toolReinforcedCobalt, "reinforced_cobalt_pickaxe");
	public static Item itemReinforcedCobaltAxe = new AxeBase(OreTools.toolReinforcedCobalt, "reinforced_cobalt_axe");
	public static Item itemReinforcedCobaltShovel = new ShovelBase(OreTools.toolReinforcedCobalt, "reinforced_cobalt_shovel");
	public static Item itemReinforcedCobaltHoe = new HoeBase(OreTools.toolReinforcedCobalt, "reinforced_cobalt_hoe");
	
	//Block:
	public static Block blockEmeraldOre = new BlockBase(Material.rock, "emerald-tools_ore");
	public static Block blockRubydOre = new BlockBase(Material.rock, "ruby_ore");
	public static Block blockSapphireOre = new BlockBase(Material.rock, "sapphire_ore");
	public static Block blockCobaltOre = new BlockBase(Material.rock, "cobalt_ore");
	public static Block blockEmerald = new BlockBase(Material.rock, "emerald-tools_block");
	public static Block blockRuby = new BlockBase(Material.rock, "ruby_block");
	public static Block blockSapphire = new BlockBase(Material.rock, "sapphire_block");
	public static Block blockCobalt = new BlockBase(Material.rock, "cobalt_block");
	public static Block blockReinforcedCobalt = new BlockBase(Material.rock, "reinforced_cobalt_block");
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CommonProxy.config = new Configuration(event.getSuggestedConfigurationFile());

		proxy.initConfig();
		
		//Registry
		//-Item:
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools"), "emerald-tools", OreTools.itemEmerald);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby"), "ruby", OreTools.itemRuby);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire"), "sapphire", OreTools.itemSapphire);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt"), "cobalt", OreTools.itemCobalt);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt"), "reinforced_cobalt", OreTools.itemReinforcedCobalt);
		
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_helmet"), "emerald-tools_helmet", OreTools.itemEmeraldHelmet);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_chestplate"), "emerald-tools_chestplate", OreTools.itemEmeraldChestplate);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_leggings"), "emerald-tools_leggings", OreTools.itemEmeraldLeggings);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_boots"), "emerald-tools_boots", OreTools.itemEmeraldBoots);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_helmet"), "ruby_helmet", OreTools.itemRubyHelmet);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_chestplate"), "ruby_chestplate", OreTools.itemRubyChestplate);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_leggings"), "ruby_leggings", OreTools.itemRubyLeggings);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_boots"), "ruby_boots", OreTools.itemRubyBoots);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_helmet"), "sapphire_helmet", OreTools.itemSapphireHelmet);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_chestplate"), "sapphire_chestplate", OreTools.itemSapphireChestplate);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_leggings"), "sapphire_leggings", OreTools.itemSapphireLeggings);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_boots"), "sapphire_boots", OreTools.itemSapphireBoots);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_helmet"), "cobalt_helmet", OreTools.itemCobaltHelmet);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_chestplate"), "cobalt_chestplate", OreTools.itemCobaltChestplate);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_leggings"), "cobalt_leggings", OreTools.itemCobaltLeggings);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_boots"), "cobalt_boots", OreTools.itemCobaltBoots);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_helmet"), "reinforced_cobalt_helmet", OreTools.itemReinforcedCobaltHelmet);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_chestplate"), "reinforced_cobalt_chestplate", OreTools.itemReinforcedCobaltChestplate);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_leggings"), "reinforced_cobalt_leggings", OreTools.itemReinforcedCobaltLeggings);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_boots"), "reinforced_cobalt_boots", OreTools.itemReinforcedCobaltBoots);

		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_sword"), "emerald-tools_sword", OreTools.itemEmeraldSword);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_pickaxe"), "emerald-tools_pickaxe", OreTools.itemEmeraldPickaxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_axe"), "emerald-tools_axe", OreTools.itemEmeraldAxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_shovel"), "emerald-tools_shovel", OreTools.itemEmeraldShovel);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("emerald-tools_hoe"), "emerald-tools_hoe", OreTools.itemEmeraldHoe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_sword"), "ruby_sword", OreTools.itemRubySword);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_pickaxe"), "ruby_pickaxe", OreTools.itemRubyPickaxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_axe"), "ruby_axe", OreTools.itemRubyAxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_shovel"), "ruby_shovel", OreTools.itemRubyShovel);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("ruby_hoe"), "ruby_hoe", OreTools.itemRubyHoe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_sword"), "sapphire_sword", OreTools.itemSapphireSword);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_pickaxe"), "sapphire_pickaxe", OreTools.itemSapphirePickaxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_axe"), "sapphire_axe", OreTools.itemSapphireAxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_shovel"), "sapphire_shovel", OreTools.itemSapphireShovel);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("sapphire_hoe"), "sapphire_hoe", OreTools.itemSapphireHoe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_sword"), "cobalt_sword", OreTools.itemCobaltSword);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_pickaxe"), "cobalt_pickaxe", OreTools.itemCobaltPickaxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_axe"), "cobalt_axe", OreTools.itemCobaltAxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_shovel"), "cobalt_shovel", OreTools.itemCobaltShovel);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("cobalt_hoe"), "cobalt_hoe", OreTools.itemCobaltHoe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_sword"), "reinforced_cobalt_sword", OreTools.itemReinforcedCobaltSword);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_pickaxe"), "reinforced_cobalt_pickaxe", OreTools.itemReinforcedCobaltPickaxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_axe"), "reinforced_cobalt_axe", OreTools.itemReinforcedCobaltAxe);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_shovel"), "reinforced_cobalt_shovel", OreTools.itemReinforcedCobaltShovel);
		GameData.getItemRegistry().addObject(CommonProxy.itemList.get("reinforced_cobalt_hoe"), "reinforced_cobalt_hoe", OreTools.itemReinforcedCobaltHoe);
		
		//-ItemBlock:
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("emerald-tools_ore"), "emerald-tools_ore", new ItemBlock(OreTools.blockEmeraldOre));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("ruby_ore"), "ruby_ore", new ItemBlock(OreTools.blockRubydOre));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("sapphire_ore"), "sapphire_ore", new ItemBlock(OreTools.blockSapphireOre));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("cobalt_ore"), "cobalt_ore", new ItemBlock(OreTools.blockCobaltOre));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("emerald-tools_block"), "emerald-tools_block", new ItemBlock(OreTools.blockEmerald));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("ruby_block"), "ruby_block", new ItemBlock(OreTools.blockRuby));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("sapphire_block"), "sapphire_block", new ItemBlock(OreTools.blockSapphire));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("cobalt_block"), "cobalt_block", new ItemBlock(OreTools.blockCobalt));
		GameData.getItemRegistry().addObject(CommonProxy.blockList.get("reinforced_cobalt_block"), "reinforced_cobalt_block", new ItemBlock(OreTools.blockReinforcedCobalt));
		
		//-Block: /!\ Il faut enrigistrer l'ItemBlock puis le Block sinon impossible de l'avoir dans l'inventaire /!\
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("emerald-tools_ore"), "emerald-tools_ore", OreTools.blockEmeraldOre);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("ruby_ore"), "ruby_ore", OreTools.blockRubydOre);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("sapphire_ore"), "sapphire_ore", OreTools.blockSapphireOre);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("cobalt_ore"), "cobalt_ore", OreTools.blockCobaltOre);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("emerald-tools_block"), "emerald-tools_block", OreTools.blockEmerald);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("ruby_block"), "ruby_block", OreTools.blockRuby);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("sapphire_block"), "sapphire_block", OreTools.blockSapphire);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("cobalt_block"), "cobalt_block", OreTools.blockCobalt);
		GameData.getBlockRegistry().addObject(CommonProxy.blockList.get("reinforced_cobalt_block"), "reinforced_cobalt_block", OreTools.blockReinforcedCobalt);
		
		//Generator:
		GameRegistry.registerWorldGenerator(new OreToolsWorldGenerator(), 0);
		
		//Smelting
		GameRegistry.addSmelting(OreTools.blockEmeraldOre, new ItemStack(OreTools.itemEmerald), 1.0f);
		GameRegistry.addSmelting(OreTools.blockRubydOre, new ItemStack(OreTools.itemRuby), 1.0f);
		GameRegistry.addSmelting(OreTools.blockSapphireOre, new ItemStack(OreTools.itemSapphire), 1.0f);
		GameRegistry.addSmelting(OreTools.blockCobaltOre, new ItemStack(OreTools.itemCobalt), 1.0f);
		
		//Recipe:
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobalt),
			new Object[] {
				"csc",
				"csc",
				"ccc",
				's', OreTools.blockSapphire,
				'c', OreTools.blockCobalt
			}
		);
		
		GameRegistry.addRecipe(new ItemStack(OreTools.blockEmerald),
			new Object[] {
				"eee",
				"eee",
				"eee",
				'e', OreTools.itemEmerald
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.blockRuby),
			new Object[] {
				"rrr",
				"rrr",
				"rrr",
				'r', OreTools.itemRuby
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.blockSapphire),
			new Object[] {
				"sss",
				"sss",
				"sss",
				's', OreTools.itemSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.blockCobalt),
			new Object[] {
				"ccc",
				"ccc",
				"ccc",
				'c', OreTools.itemCobalt
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.blockReinforcedCobalt),
			new Object[] {
				"rrr",
				"rrr",
				"rrr",
				'r', OreTools.itemReinforcedCobalt
			}
		);
		
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldHelmet),
			new Object[] {
				"eee",
				"e e",
				'e', OreTools.itemEmerald
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldChestplate),
			new Object[] {
				"e e",
				"eee",
				"eee",
				'e', OreTools.itemEmerald
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldLeggings),
			new Object[] {
				"eee",
				"e e",
				"e e",
				'e', OreTools.itemEmerald
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldBoots),
			new Object[] {
				"e e",
				"e e",
				'e', OreTools.itemEmerald
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyHelmet),
			new Object[] {
				"rrr",
				"r r",
				'r', OreTools.itemRuby
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyChestplate),
			new Object[] {
				"r r",
				"rrr",
				"rrr",
				'r', OreTools.itemRuby
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyLeggings),
			new Object[] {
				"rrr",
				"r r",
				"r r",
				'r', OreTools.itemRuby
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyBoots),
			new Object[] {
				"r r",
				"r r",
				'r', OreTools.itemRuby
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireHelmet),
			new Object[] {
				"sss",
				"s s",
				's', OreTools.itemSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireChestplate),
			new Object[] {
				"s s",
				"sss",
				"sss",
				's', OreTools.itemSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireLeggings),
			new Object[] {
				"sss",
				"s s",
				"s s",
				's', OreTools.itemSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireBoots),
			new Object[] {
				"s s",
				"s s",
				's', OreTools.itemSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltHelmet),
			new Object[] {
				"ScC",
				"c c",
				'c', OreTools.itemCobalt,
				'C', OreTools.blockCobalt,
				'S', OreTools.blockSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltChestplate),
			new Object[] {
				"c c",
				"cCc",
				"cSc",
				'c', OreTools.itemCobalt,
				'C', OreTools.blockCobalt,
				'S', OreTools.blockSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltLeggings),
			new Object[] {
				"ScC",
				"c c",
				"c c",
				'c', OreTools.itemCobalt,
				'C', OreTools.blockCobalt,
				'S', OreTools.blockSapphire
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltBoots),
			new Object[] {
				"S C",
				"c c",
				'c', OreTools.itemCobalt,
				'C', OreTools.blockCobalt,
				'S', OreTools.blockSapphire
			}
		);

		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltHelmet),
			new Object[] {
				"rrr",
				"r r",
				'r', OreTools.itemReinforcedCobalt
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltChestplate),
			new Object[] {
				"r r",
				"rrr",
				"rrr",
				'r', OreTools.itemReinforcedCobalt
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltLeggings),
			new Object[] {
				"rrr",
				"r r",
				"r r",
				'r', OreTools.itemReinforcedCobalt
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltBoots),
			new Object[] {
				"r r",
				"r r",
				'r', OreTools.itemReinforcedCobalt
			}
		);

		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldSword),
			new Object[] {
				"e",
				"e",
				"b",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldPickaxe),
			new Object[] {
				"eee",
				" b ",
				" b ",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldAxe),
			new Object[] {
				"ee ",
				"eb ",
				" b ",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldAxe),
			new Object[] {
				" ee",
				" be",
				" b ",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldShovel),
			new Object[] {
				"e",
				"b",
				"b",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldHoe),
			new Object[] {
				"ee ",
				" b ",
				" b ",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemEmeraldHoe),
			new Object[] {
				" ee",
				" b ",
				" b ",
				'e', OreTools.itemEmerald,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubySword),
			new Object[] {
				"r",
				"r",
				"b",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyPickaxe),
			new Object[] {
				"rrr",
				" b ",
				" b ",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyAxe),
			new Object[] {
				"rr ",
				"rb ",
				" b ",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyAxe),
			new Object[] {
				" rr",
				" br",
				" b ",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyShovel),
			new Object[] {
				"r",
				"b",
				"b",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyHoe),
			new Object[] {
				"rr ",
				" b ",
				" b ",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemRubyHoe),
			new Object[] {
				" rr",
				" b ",
				" b ",
				'r', OreTools.itemRuby,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireSword),
			new Object[] {
				"s",
				"s",
				"b",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphirePickaxe),
			new Object[] {
				"sss",
				" b ",
				" b ",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireAxe),
			new Object[] {
				"ss ",
				"sb ",
				" b ",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireAxe),
			new Object[] {
				" ss",
				" bs",
				" b ",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireShovel),
			new Object[] {
				"s",
				"b",
				"b",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireHoe),
			new Object[] {
				"ss ",
				" b ",
				" b ",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemSapphireHoe),
			new Object[] {
				" ss",
				" b ",
				" b ",
				's', OreTools.itemSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltSword),
			new Object[] {
				"SCS",
				"ScS",
				"SbS",
				'c', OreTools.itemCobalt,
				'C', OreTools.blockCobalt,
				'S', OreTools.blockSapphire,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltPickaxe),
			new Object[] {
				"ccc",
				" b ",
				" b ",
				'c', OreTools.itemCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltAxe),
			new Object[] {
				"cc ",
				"cb ",
				" b ",
				'c', OreTools.itemCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltAxe),
			new Object[] {
				" cc",
				" bc",
				" b ",
				'c', OreTools.itemCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltShovel),
			new Object[] {
				"c",
				"b",
				"b",
				'c', OreTools.itemCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltHoe),
			new Object[] {
				"cc ",
				" b ",
				" b ",
				'c', OreTools.itemCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemCobaltHoe),
			new Object[] {
				" cc",
				" b ",
				" b ",
				'c', OreTools.itemCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltSword),
			new Object[] {
				"r",
				"r",
				"b",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltPickaxe),
			new Object[] {
				"rrr",
				" b ",
				" b ",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltAxe),
			new Object[] {
				"rr ",
				"rb ",
				" b ",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltAxe),
			new Object[] {
				" rr",
				" br",
				" b ",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltShovel),
			new Object[] {
				"r",
				"b",
				"b",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltHoe),
			new Object[] {
				"rr ",
				" b ",
				" b ",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OreTools.itemReinforcedCobaltHoe),
			new Object[] {
				" rr",
				" b ",
				" b ",
				'r', OreTools.itemReinforcedCobalt,
				'b', Items.stick
			}
		);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
