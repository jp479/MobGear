package com.jp479.mobgear.datagen;

import java.util.concurrent.CompletableFuture;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.block.ModBlocks;
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
import net.minecraft.util.Identifier;

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

                // Blocks
                offerReversibleCompactingRecipes(
                        RecipeCategory.MISC, ModItems.BLAZED_DIAMOND,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLAZED_DIAMOND_BLOCK
                );

                offerReversibleCompactingRecipes(
                        RecipeCategory.MISC, ModItems.ENDER_IRON_INGOT,
                        RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDER_IRON_BLOCK
                );

                // Items
                createShapeless(RecipeCategory.MISC, ModItems.WITHER_BONE, 3)
                        .input(Items.WITHER_SKELETON_SKULL)
                        .group("multi_bench")
                        .criterion(hasItem(Items.WITHER_SKELETON_SKULL), conditionsFromItem(Items.WITHER_SKELETON_SKULL))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.CHORUS_STICK, 1)
                        .input(Items.STICK)
                        .input(Items.POPPED_CHORUS_FRUIT)
                        .criterion(hasItem(Items.POPPED_CHORUS_FRUIT), conditionsFromItem(Items.POPPED_CHORUS_FRUIT))
                        .offerTo(exporter);;

                createShaped(RecipeCategory.MISC, ModItems.BLAZED_DIAMOND, 1)
                        .pattern(" B ")
                        .pattern("BDB")
                        .pattern(" B ")
                        .input('B', Items.BLAZE_POWDER)
                        .input('D', Items.DIAMOND)
                        .group("multi_bench")
                        .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                        .offerTo(exporter, String.valueOf(Identifier.of(MobGear.MOD_ID, "blazed_diamond_from_blaze_and_diamond")));

                createShaped(RecipeCategory.MISC, ModItems.ENDER_IRON_INGOT, 1)
                        .pattern(" E ")
                        .pattern("EIE")
                        .pattern(" E ")
                        .input('E', Items.ENDER_PEARL)
                        .input('I', Items.IRON_INGOT)
                        .group("multi_bench")
                        .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                        .offerTo(exporter, String.valueOf(Identifier.of(MobGear.MOD_ID, "ender_iron_from_ender_and_iron")));

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

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERMAN_SWORD, 1)
                        .pattern(" E ")
                        .pattern(" E " )
                        .pattern(" S ")
                        .input('E', ModItems.ENDER_IRON_INGOT)
                        .input('S', ModItems.CHORUS_STICK)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.ENDER_IRON_INGOT), conditionsFromItem(ModItems.ENDER_IRON_INGOT))
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

                createShaped(RecipeCategory.COMBAT, ModItems.SKELETON_BOW, 1)
                        .pattern(" BS")
                        .pattern("B S")
                        .pattern(" BS")
                        .input('B', Items.BONE)
                        .input('S', Items.STRING)
                        .group("multi_bench")
                        .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.WITHER_SKELETON_BOW, 1)
                        .pattern(" WS")
                        .pattern("WBS")
                        .pattern(" WS")
                        .input('W', ModItems.WITHER_BONE)
                        .input('S', Items.STRING)
                        .input('B', ModItems.SKELETON_BOW)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.WITHER_BONE), conditionsFromItem(ModItems.WITHER_BONE))
                        .offerTo(exporter);

                // Armor
                createShaped(RecipeCategory.COMBAT, ModItems.BAT_HELMET, 1)
                        .pattern("B B")
                        .pattern(" L ")
                        .input('B', ModItems.BAT_EAR)
                        .input('L', Items.LEATHER_HELMET)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.BAT_EAR), conditionsFromItem(ModItems.BAT_EAR))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.IRON_GOLEM_CHESTPLATE, 1)
                        .pattern("BIB")
                        .pattern("BPB")
                        .pattern("BRB")
                        .input('B', Items.IRON_BLOCK)
                        .input('I', Items.IRON_CHESTPLATE)
                        .input('P', Items.CARVED_PUMPKIN)
                        .input('R', Items.POPPY)
                        .group("multi_bench")
                        .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.SLIME_LEGGINGS, 1)
                        .pattern("SSS")
                        .pattern("SCS")
                        .pattern("S S")
                        .input('S', Items.SLIME_BALL)
                        .input('C', Items.CHAINMAIL_LEGGINGS)
                        .group("multi_bench")
                        .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.MAGMA_CUBE_LEGGINGS, 1)
                        .pattern("MMM")
                        .pattern("MSM")
                        .pattern("M M")
                        .input('M', Items.MAGMA_CREAM)
                        .input('S', ModItems.SLIME_LEGGINGS)
                        .group("multi_bench")
                        .criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.OCELOT_BOOTS, 1)
                        .pattern(" L ")
                        .pattern("O O")
                        .input('L', Items.LEATHER_BOOTS)
                        .input('O', ModItems.OCELOT_PAW)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.OCELOT_PAW), conditionsFromItem(ModItems.OCELOT_PAW))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "MobGearRecipeProvider";
    }
}
