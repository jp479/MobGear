package com.jp479.mobgear.util;

import com.jp479.mobgear.MobGear;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BLAZED_DIAMOND = createTag("blazed_diamond");
        public static final TagKey<Block> ENDER_IRON = createTag("ender_iron");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MobGear.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BAT_EAR_REPAIR = createTag("bat_ear_repair");
        public static final TagKey<Item> OCELOT_PAW_REPAIR = createTag("ocelot_paw_repair");
        public static final TagKey<Item> SLIME_BALL_REPAIR = createTag("slime_ball_repair");
        public static final TagKey<Item> MAGMA_CREAM_REPAIR = createTag("magma_cream_repair");
        public static final TagKey<Item> BLAZED_DIAMOND_REPAIR = createTag("blazed_diamond_repair");
        public static final TagKey<Item> ENDER_IRON_REPAIR = createTag("ender_iron_repair");
        public static final TagKey<Item> IRON_BLOCK_REPAIR = createTag("iron_block_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MobGear.MOD_ID, name));
        }
    }
}
