package com.jp479.mobgear.util;

import com.jp479.mobgear.MobGear;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> BLAZED_DIAMOND_REPAIR = createTag("blazed_diamond_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MobGear.MOD_ID, name));
        }
    }
}
