package com.filloax.copyfolders.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.server.MinecraftServer;
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
//      	MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
    }

    @EventHandler   
    public void postInit(FMLPostInitializationEvent e) {

    }
    
    public File getSavesFolder(){
    	return null;
    };
        
    @EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		String name = e.getServer().getFolderName();
		File worldDir = new File(this.getSavesFolder(), name);
	    
		Boolean alreadyDone = false; //If the event has been ran on this world
		
		/*Mpserver is the name of the "clientside server" I assume, as the event 
		is run on that too, regardless of world name.*/
		if (!alreadyDone) {
			System.out.println("Copying folders for world "+worldDir+"...");	
		}
	}
}
