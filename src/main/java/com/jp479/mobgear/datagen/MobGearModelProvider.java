package com.jp479.mobgear.datagen;

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

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Items
        itemModelGenerator.register(ModItems.BAT_EAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAZED_DIAMOND, Models.GENERATED);

        // Tools & Weapons
        itemModelGenerator.register(ModItems.BLAZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLAZE_PICKAXE, Models.HANDHELD);

        // Armor
        itemModelGenerator.register(ModItems.BAT_HELMET, Models.GENERATED);
    }
}
