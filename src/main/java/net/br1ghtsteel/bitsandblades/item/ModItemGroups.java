package net.br1ghtsteel.bitsandblades.item;

import net.br1ghtsteel.bitsandblades.BitsAndBlades;
import net.br1ghtsteel.bitsandblades.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BITS_AND_BLADES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BitsAndBlades.MOD_ID, "bits_and_blades"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bits_and_blades"))
                    .icon(() -> new ItemStack(ModItems.BRONZE_INGOT))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModItems.BRONZE_INGOT);

                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        BitsAndBlades.LOGGER.info("Registering Item Groups for: " + BitsAndBlades.MOD_ID);
    }
}
