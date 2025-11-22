package com.jp479.mobgear.datagen;

import com.jp479.mobgear.item.ModItems;
import com.jp479.mobgear.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MobGearItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public MobGearItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.BAT_EAR_REPAIR)
                .add(ModItems.BAT_EAR);

        valueLookupBuilder(ModTags.Items.BLAZED_DIAMOND_REPAIR)
                .add(ModItems.BLAZED_DIAMOND);
    }
}
