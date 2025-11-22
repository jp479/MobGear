package com.jp479.mobgear.item;

import com.jp479.mobgear.util.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {
    public static final ToolMaterial BLAZE_DIAMOND_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1796,
            8.5f,
            3.0f,
            10,
            ModTags.Items.BLAZED_DIAMOND_REPAIR
    );
}
