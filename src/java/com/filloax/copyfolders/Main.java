package com.filloax.copyfolders;

import com.filloax.copyfolders.core.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

    public static final String MODID = "copyfolders";
    public static final String MODNAME = "Copy Folders in new Worlds";
    public static final String VERSION = "1.0";
        
    @Instance
    public static Main instance = new Main();
        
    @SidedProxy(clientSide="com.filloax.copyfolders.core.ClientProxy", serverSide="com.filloax.copyfolders.core.ServerProxy")
    public static CommonProxy proxy;
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);          
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
    	proxy.serverStarting(e);
    }
}
