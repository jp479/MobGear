package com.jp479.mobgear;

import com.jp479.mobgear.block.entity.ModBlockEntities;
import com.jp479.mobgear.block.entity.renderer.IronGolemCoreBlockEntityRenderer;
import com.jp479.mobgear.client.model.BatHelmetModel;
import com.jp479.mobgear.client.render.BatHelmetRenderer;
import com.jp479.mobgear.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class MobGearClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.IRON_GOLEM_CORE_BE, IronGolemCoreBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(BatHelmetModel.LAYER, BatHelmetModel::getTexturedModelData);
        ArmorRenderer.register(new BatHelmetRenderer(), ModItems.BAT_HELMET);
    }
}
