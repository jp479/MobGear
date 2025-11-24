package com.jp479.mobgear.datagen;

import com.jp479.mobgear.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MobGearBlockLootTableProvider extends FabricBlockLootTableProvider {
    public MobGearBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLAZED_DIAMOND_BLOCK);
        addDrop(ModBlocks.ENDER_IRON_BLOCK);
    }
}
