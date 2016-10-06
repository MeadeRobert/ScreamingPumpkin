package com.turnip.screamingpumpkinmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static ScreamingPumpkinBlock screamingPumpkinBlock;
	
	public static final void init()
	{
		GameRegistry.registerBlock(
				screamingPumpkinBlock = new ScreamingPumpkinBlock(
						"screamingPumpkin", Material.plants),
						"screamingPumpkin");
	}
}
