package com.jp479.mobgear.block;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block BLAZED_DIAMOND_BLOCK = register(
            "blazed_diamond_block",
            properties -> new Block(properties
                    .strength(10.0f)
                    .resistance(6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL))
    );

    private static Block register(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MobGear.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MobGear.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MobGear.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MobGear.MOD_ID, name)))));
    }

    public static void initialize() {
        MobGear.LOGGER.info("Registering Mod Blocks for " + MobGear.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(BLAZED_DIAMOND_BLOCK);
        });
    }
}
