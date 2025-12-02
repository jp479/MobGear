package com.jp479.mobgear.block.entity.custom;

import com.jp479.mobgear.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;

public class IronGolemCoreBlockEntity extends BlockEntity {
    public float rotation;

    public IronGolemCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_GOLEM_CORE_BE, pos, state);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }
}
