package com.filloax.copyfolders.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.filloax.copyfolders.Main;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.config.Configuration;

public class CommonProxy {    
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());

		config.load();

		Main.sourceFolder = new File(".",config.getString("source folder", config.CATEGORY_GENERAL, "copysource", "The folder to copy from."));

		config.save();
		
		System.out.println("Copy source folder path is "+Main.sourceFolder+".");
		
		if (!Main.sourceFolder.exists() || !Main.sourceFolder.isDirectory()) {
			System.out.println("Source folder not found. Creating it...");
			if (!Main.sourceFolder.isDirectory()) {
				System.out.println("For some reason there is a file with the same name as the folder. Renaming it...");
				Main.sourceFolder.renameTo(new File(Main.sourceFolder.toString()+"1"));
			}
			Main.sourceFolder.mkdir();
			System.out.println("Created "+Main.sourceFolder+".");
		}
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
	public void serverStarting(FMLServerStartingEvent e) throws IOException {
		String name = e.getServer().getFolderName();
		File worldDir = new File(this.getSavesFolder(), name);
		//This file is created when I'm finished copying the folder
		File alreadyDone = new File(worldDir,"copied files");
		
		if (!alreadyDone.exists()) {
			System.out.println("Copying files for world "+name+"...");
			if (Main.sourceFolder.exists()) {
				FileUtils.copyDirectory(Main.sourceFolder, worldDir);
				alreadyDone.createNewFile();
			} else {
				System.out.println("Copy source folder not found!");
			}
		}
	}
}
