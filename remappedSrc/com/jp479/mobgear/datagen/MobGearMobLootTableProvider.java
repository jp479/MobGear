package com.jp479.mobgear.datagen;

import com.jp479.mobgear.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MobGearMobLootTableProvider extends FabricEntityLootTableProvider {
    public MobGearMobLootTableProvider(FabricDataOutput output, @NotNull CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        LootPool pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.1f))
                .with(ItemEntry.builder(ModItems.BAT_EAR)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f))))
                .build();

        register(EntityType.BAT, LootTable.builder().pool(pool));
    }
}
