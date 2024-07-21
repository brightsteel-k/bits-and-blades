package net.br1ghtsteel.bitsandblades.datagen;

import net.br1ghtsteel.bitsandblades.BitsAndBlades;
import net.br1ghtsteel.bitsandblades.block.ModBlocks;
import net.br1ghtsteel.bitsandblades.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> TIN_SMELTABLES = List.of(ModItems.RAW_TIN);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_TIN, RecipeCategory.DECORATIONS, ModBlocks.RAW_TIN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.DECORATIONS, ModBlocks.TIN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BRONZE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK);

        offerSmelting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.7f, 200, "tin");
        offerBlasting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.7f, 100, "tin");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_TIN, 1)
                .pattern(" S ")
                .pattern("STS")
                .pattern(" S ")
                .input('S', ItemTags.STONE_CRAFTING_MATERIALS)
                .input('T', ModItems.TIN_INGOT)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, new Identifier(BitsAndBlades.MOD_ID, "raw_tin_from_tin_ingot"));

    }
}
