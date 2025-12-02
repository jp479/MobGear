package com.jp479.mobgear.datagen;

import com.jp479.mobgear.block.ModBlocks;
import com.jp479.mobgear.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.numeric.UseDurationProperty;
import net.minecraft.item.Item;

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
        itemModelGenerator.register(ModItems.OCELOT_PAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHER_BONE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHORUS_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_ROD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLAZED_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_IRON_INGOT, Models.GENERATED);

        // Tools & Weapons
        itemModelGenerator.register(ModItems.BLAZE_SWORD, Models.HANDHELD);
        registerChargeableSword(itemModelGenerator, ModItems.ENDERMAN_SWORD);
        itemModelGenerator.register(ModItems.BLAZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_GOLEM_MACE, Models.HANDHELD);
        itemModelGenerator.registerBow(ModItems.SKELETON_BOW);
        itemModelGenerator.registerBow(ModItems.WITHER_SKELETON_BOW);

        // Armor
        itemModelGenerator.register(ModItems.BAT_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_GOLEM_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIME_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGMA_CUBE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.OCELOT_BOOTS, Models.GENERATED);
    }

    public static void registerChargeableSword(ItemModelGenerator generator, Item item) {
        ItemModel.Unbaked base = ItemModels.basic(ModelIds.getItemModelId(item));

        ItemModel.Unbaked charging0 = ItemModels.basic(
                generator.registerSubModel(item, "_charging_0", Models.HANDHELD)
        );
        ItemModel.Unbaked charging1 = ItemModels.basic(
                generator.registerSubModel(item, "_charging_1", Models.HANDHELD)
        );
        ItemModel.Unbaked charging2 = ItemModels.basic(
                generator.registerSubModel(item, "_charging_2", Models.HANDHELD)
        );

        generator.output.accept(item,
                ItemModels.condition(
                        ItemModels.usingItemProperty(),
                        ItemModels.rangeDispatch(
                                new UseDurationProperty(false),
                                0.05F,
                                charging0,
                                ItemModels.rangeDispatchEntry(charging1, 0.65F),
                                ItemModels.rangeDispatchEntry(charging2, 0.9F)
                        ),
                        base
                )
        );
    }
}
