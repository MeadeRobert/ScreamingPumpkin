package com.turnip.screamingpumpkinmod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	 @EventHandler
	 public void preInit(FMLPreInitializationEvent e)
	 {
		 ModItems.init();
	 }
	    
	 @EventHandler
	 public void init(FMLInitializationEvent e){}
	    
	 @EventHandler
	 public void postInit(FMLPostInitializationEvent e) {}
}
