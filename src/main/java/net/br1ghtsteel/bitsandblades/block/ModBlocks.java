package net.br1ghtsteel.bitsandblades.block;

import net.br1ghtsteel.bitsandblades.BitsAndBlades;
import net.br1ghtsteel.bitsandblades.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BitsAndBlades.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BitsAndBlades.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BitsAndBlades.LOGGER.info("Registering Mod Blocks for: " + BitsAndBlades.MOD_ID);
    }
}
