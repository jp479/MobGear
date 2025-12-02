package com.jp479.mobgear.block;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.block.custom.IronGolemCoreBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.HeavyCoreBlock;
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
    public static final Block ENDER_IRON_BLOCK = register(
            "ender_iron_block",
            properties -> new Block(properties
                    .strength(10.0f)
                    .resistance(6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL))
    );
    public static final Block IRON_GOLEM_CORE = register(
            "iron_golem_core",
            properties -> new IronGolemCoreBlock(properties
                    .strength(10.0f)
                    .resistance(1200.0f)
                    .sounds(BlockSoundGroup.HEAVY_CORE))
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
        MobGear.LOGGER.info("Registering mod blocks for " + MobGear.MOD_ID);
    }
}
