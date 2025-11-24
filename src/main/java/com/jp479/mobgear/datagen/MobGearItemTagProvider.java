package com.jp479.mobgear.datagen;

import com.jp479.mobgear.item.ModItems;
import com.jp479.mobgear.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

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

        valueLookupBuilder(ModTags.Items.ENDER_IRON_REPAIR)
                .add(ModItems.ENDER_IRON_INGOT);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.BLAZE_PICKAXE);

        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.BLAZE_PICKAXE);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.BLAZE_SWORD)
                .add(ModItems.ENDERMAN_SWORD);

        valueLookupBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.BLAZE_SWORD)
                .add(ModItems.ENDERMAN_SWORD);

        valueLookupBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.BLAZE_SWORD)
                .add(ModItems.ENDERMAN_SWORD);

        valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.BLAZE_SWORD)
                .add(ModItems.ENDERMAN_SWORD);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.BAT_HELMET);

        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.BAT_HELMET);

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.SKELETON_BOW)
                .add(ModItems.WITHER_SKELETON_BOW);
    }
}
