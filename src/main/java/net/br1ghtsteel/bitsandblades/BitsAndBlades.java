package net.br1ghtsteel.bitsandblades;

import net.br1ghtsteel.bitsandblades.block.ModBlocks;
import net.br1ghtsteel.bitsandblades.item.ModItemGroups;
import net.br1ghtsteel.bitsandblades.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitsAndBlades implements ModInitializer {

    public static final String MOD_ID = "bitsandblades";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}