package com.turnip.screamingpumpkinmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class ModItems
{	
	public static Item screamer;
	
	public static final void init()
	{
		screamer = new Item()
				.setUnlocalizedName("Screamer")
				.setCreativeTab(CreativeTabs.tabMisc)
				.setTextureName(ScreamingPumpkin.MODID + ":screamer");
		GameRegistry.registerItem(screamer,  "Screamer");
	}
}
