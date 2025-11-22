package com.jp479.mobgear.datagen;

import java.util.concurrent.CompletableFuture;

import com.jp479.mobgear.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class MobGearRecipeProvider extends FabricRecipeProvider {
    public MobGearRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                // Items
                createShaped(RecipeCategory.COMBAT, ModItems.BLAZED_DIAMOND, 1)
                        .pattern(" B ")
                        .pattern("BDB")
                        .pattern(" B ")
                        .input('B', Items.BLAZE_POWDER)
                        .input('D', Items.DIAMOND)
                        .group("multi_bench")
                        .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                        .offerTo(exporter);

                // Tools & Weapons
                createShaped(RecipeCategory.COMBAT, ModItems.BLAZE_SWORD, 1)
                        .pattern(" B ")
                        .pattern(" B " )
                        .pattern(" R ")
                        .input('B', ModItems.BLAZED_DIAMOND)
                        .input('R', Items.BLAZE_ROD)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.BLAZED_DIAMOND), conditionsFromItem(ModItems.BLAZED_DIAMOND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.BLAZE_PICKAXE, 1)
                        .pattern("BBB")
                        .pattern(" R ")
                        .pattern(" R ")
                        .input('B', ModItems.BLAZED_DIAMOND)
                        .input('R', Items.BLAZE_ROD)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.BLAZED_DIAMOND), conditionsFromItem(ModItems.BLAZED_DIAMOND))
                        .offerTo(exporter);

                // Armor
                createShaped(RecipeCategory.COMBAT, ModItems.BAT_HELMET, 1)
                        .pattern("B B")
                        .pattern("LLL")
                        .pattern("L L")
                        .input('B', ModItems.BAT_EAR)
                        .input('L', Items.LEATHER)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.BAT_HELMET), conditionsFromItem(ModItems.BAT_HELMET))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "MobGearRecipeProvider";
    }
}