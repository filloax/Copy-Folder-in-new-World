package com.filloax.copyfolders.core;

import com.filloax.copyfolders.event.EventHandlerCommon;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

public class CommonProxy {    
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());

		config.load();

			
		config.save();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent e) {
    }

    @EventHandler   
    public void postInit(FMLPostInitializationEvent e) {

    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent e) {
 
    }
    
}
