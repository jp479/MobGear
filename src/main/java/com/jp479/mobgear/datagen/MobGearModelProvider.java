package com.jp479.mobgear.datagen;

import com.jp479.mobgear.block.ModBlocks;
import com.jp479.mobgear.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class MobGearModelProvider extends FabricModelProvider {

    public MobGearModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLAZED_DIAMOND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_IRON_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Items
        itemModelGenerator.register(ModItems.BAT_EAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHER_BONE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHORUS_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLAZED_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_IRON_INGOT, Models.GENERATED);

        // Tools & Weapons
        itemModelGenerator.register(ModItems.BLAZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERMAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLAZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.registerBow(ModItems.SKELETON_BOW);
        itemModelGenerator.registerBow(ModItems.WITHER_SKELETON_BOW);

        // Armor
        itemModelGenerator.register(ModItems.BAT_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIME_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGMA_CUBE_LEGGINGS, Models.GENERATED);
    }
}
