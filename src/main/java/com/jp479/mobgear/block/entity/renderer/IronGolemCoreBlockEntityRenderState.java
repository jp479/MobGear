package com.jp479.mobgear.block.entity.renderer;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronGolemCoreBlockEntityRenderState extends BlockEntityRenderState {
    public BlockPos lightPosition;
    public World blockEntityWorld;

    public float rotation;
    public float bob;

    public final ItemRenderState itemRenderState = new ItemRenderState();
}
