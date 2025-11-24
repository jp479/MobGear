package com.jp479.mobgear.datagen;

import com.jp479.mobgear.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MobGearBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public MobGearBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLAZED_DIAMOND_BLOCK)
                .add(ModBlocks.ENDER_IRON_BLOCK)
;
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLAZED_DIAMOND_BLOCK)
                .add(ModBlocks.ENDER_IRON_BLOCK);
    }
}
