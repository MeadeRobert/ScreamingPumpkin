package com.turnip.screamingpumpkinmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class ModItems
{	
	public static Item screamPowder;
	
	public static final void init()
	{
		screamPowder = new Item()
				.setUnlocalizedName("screamPowder")
				.setCreativeTab(CreativeTabs.tabMisc)
				.setTextureName(ScreamingPumpkin.MODID + ":screamPowder");
		GameRegistry.registerItem(screamPowder,  "screamPowder");
	}
}
