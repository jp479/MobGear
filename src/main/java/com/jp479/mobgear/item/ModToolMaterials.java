package com.jp479.mobgear.item;

import com.jp479.mobgear.util.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {
    public static final ToolMaterial BLAZE_DIAMOND_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1796,
            8.0f,
            4.0f,
            10,
            ModTags.Items.BLAZED_DIAMOND_REPAIR
    );
    public static final ToolMaterial ENDER_IRON_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1796,
            8.0f,
            4.0f,
            10,
            ModTags.Items.ENDER_IRON_REPAIR
    );
    public static final ToolMaterial IRON_BLOCK_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1796,
            8.0f,
            4.0f,
            10,
            ModTags.Items.IRON_BLOCK_REPAIR
    );
}
