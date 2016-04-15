package com.filloax.copyfolders.event;

import java.util.ArrayList;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.world.WorldEvent;

public class EventHandlerCommon {
	public static ArrayList<String> worlds = new ArrayList<String>(); /*Worlds the event has been run on,
	 to prevent it being done multiple times 
	(it happened for some reason)*/
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onWorldLoad(WorldEvent.Load e) {
		String name = MinecraftServer.getServer().getFolderName();
		Boolean alreadyDone = false; //If the event has been ran on this world
		
		for (String listname : worlds) {
			if (listname.equals(name)) {
				alreadyDone = true;
				break;
			}
		}
		
		/*Mpserver is the name of the "clientside server" I assume, as the event 
		is run on that too, regardless of world name.*/
		if (!alreadyDone && !name.equals("MpServer")) {
			System.out.println("Copying folders for world "+name+"...");	
			worlds.add(name);
		}
	}
}
