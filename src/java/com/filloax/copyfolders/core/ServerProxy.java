package com.filloax.copyfolders.core;

import java.io.File;
import java.io.IOException;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.server.FMLServerHandler;

public class ServerProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
    @Override
    public void serverStarting(FMLServerStartingEvent e) throws IOException {
    	super.serverStarting(e);
    }
    
    @Override
    public File getSavesFolder() {
    	return FMLServerHandler.instance().getSavesDirectory();
    }
}
