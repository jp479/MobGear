package com.jp479.mobgear.client.render;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.client.model.BatHelmetModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.command.RenderCommandQueue;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BatHelmetRenderer implements ArmorRenderer {
    private BatHelmetModel model;

    @Override
    public void render(
            MatrixStack matrices,
            OrderedRenderCommandQueue queue,
            ItemStack stack,
            BipedEntityRenderState state,
            EquipmentSlot slot,
            int light,
            BipedEntityModel<BipedEntityRenderState> contextModel
    ) {
        if (slot != EquipmentSlot.HEAD) return;

        if (model == null) {
            model = new BatHelmetModel(
                    MinecraftClient.getInstance()
                            .getLoadedEntityModels()
                            .getModelPart(BatHelmetModel.LAYER)
            );
        }

        Identifier texture = Identifier.of(
                MobGear.MOD_ID,
                "textures/entity/equipment/humanoid/bat_ear.png"
        );

        matrices.push();

        contextModel.head.applyTransform(matrices);

        model.resetTransforms();

        RenderCommandQueue batch = queue.getBatchingQueue(0);

        batch.submitModel(
                model,
                state,
                matrices,
                model.getLayer(texture),
                light,
                OverlayTexture.DEFAULT_UV,
                0xFFFFFF,
                null,
                0,
                null
        );

        matrices.pop();
    }

    @Override
    public boolean shouldRenderDefaultHeadItem(LivingEntity entity, ItemStack stack) {
        return false;
    }
}
