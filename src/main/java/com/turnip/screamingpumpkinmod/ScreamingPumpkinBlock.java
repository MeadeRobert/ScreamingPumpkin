package com.turnip.screamingpumpkinmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ScreamingPumpkinBlock extends Block
{
	protected ScreamingPumpkinBlock(String unlocalizedName, Material m)
	{
		super(m);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(ScreamingPumpkin.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		System.out.println(GameRegistry.findBlock("minecraft", "pumpkin"));
//		this.setHardness(((ScreamingPumpkinBlock) GameRegistry.findBlock("minecraft", "pumpkin")).blockHardness);
//		this.setResistance(((ScreamingPumpkinBlock) GameRegistry.findBlock("minecraft", "pumpkin")).blockResistance);
	}
}
