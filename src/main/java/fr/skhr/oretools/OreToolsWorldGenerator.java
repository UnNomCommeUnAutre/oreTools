package fr.skhr.oretools;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreToolsWorldGenerator implements IWorldGenerator {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	    switch(world.provider.dimensionId) {
	        case -1:
		        generateNether(world, random, chunkX * 16, chunkZ * 16);
		        break;
	        case 0:
	        	generateWorld(world, random, chunkX * 16, chunkZ * 16);
		        break;
	        case 1:
		        generateEnd(world, random, chunkX * 16, chunkZ * 16);
		        break;
	    }
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		 
	}
	 
	private void generateWorld(World world, Random random, int x, int z) {
		this.addOreSpawn(OreTools.blockEmeraldOre, 0, Blocks.stone, world, random, x, z, 16, 16, 4, 40, 0, 16);
		this.addOreSpawn(OreTools.blockRubydOre, 0, Blocks.stone, world, random, x, z, 16, 16, 4, 30, 0, 16);
		this.addOreSpawn(OreTools.blockSapphireOre, 0, Blocks.stone, world, random, x, z, 16, 16, 4, 15, 0, 16);
		this.addOreSpawn(OreTools.blockCobaltOre, 0, Blocks.stone, world, random, x, z, 16, 16, 3, 5, 0, 16);
	}
	 
	private void generateNether(World world, Random random, int x, int z) {
	 
	}
	
	public void addOreSpawn(Block block, int metadata, Block target, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		for(int i = 0; i < chancesToSpawn; i++) {
	        int posY = random.nextInt(128);
	 
	        if((posY <= maxY) && (posY >= minY)) {
	        	(new WorldGenMinable(block, metadata, maxVeinSize, target)).generate(world, random, blockXPos + random.nextInt(16), posY, blockZPos + random.nextInt(16));
	        }
	    }
	}
}
