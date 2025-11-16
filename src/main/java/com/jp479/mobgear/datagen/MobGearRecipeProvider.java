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