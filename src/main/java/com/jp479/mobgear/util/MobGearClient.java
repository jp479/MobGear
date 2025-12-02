package com.jp479.mobgear.util;

import com.jp479.mobgear.block.entity.ModBlockEntities;
import com.jp479.mobgear.block.entity.renderer.IronGolemCoreBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class MobGearClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.IRON_GOLEM_CORE_BE, IronGolemCoreBlockEntityRenderer::new);
    }
}
