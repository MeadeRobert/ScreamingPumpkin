package com.turnip.screamingpumpkinmod;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.*;

@Mod(modid = ScreamingPumpkin.MODID, name = ScreamingPumpkin.MODNAME, version = ScreamingPumpkin.VERSION)
public class ScreamingPumpkin
{	
    public static final String MODID = "screamingpumpkin";
    public static final String MODNAME = "Screaming Pumpkin Mod";
    public static final String VERSION = "1.0";
    
    @SidedProxy(
    		clientSide="com.turnip.screamingpumpkinmod.ClientProxy",
    		serverSide="com.turnip.screamingpumpkinmod.ServerProxy")
    public static CommonProxy proxy;
    
    @Instance
    public static ScreamingPumpkin instance = new ScreamingPumpkin();
    
    public static final Logger log = LogManager.getLogger(ScreamingPumpkin.class.getName());
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	proxy.preInit(e);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	proxy.init(e);
    	FMLLog.log(Level.INFO, "Test Log >> Test Message");
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	proxy.postInit(e);
    }
}
