package com.jp479.mobgear.client.model;

import com.jp479.mobgear.MobGear;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.Dilation;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BatHelmetModel extends Model<BipedEntityRenderState> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(Identifier.of(MobGear.MOD_ID, "bat_helmet"), "main");
    public final ModelPart head;

    public BatHelmetModel(ModelPart root) {
        super(root, RenderLayer::getArmorCutoutNoCull);
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        ModelPartData head = root.addChild(
                "head",
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-4, -8, -4, 8, 8, 8, new Dilation(1.0F))
                        .uv(32, 0)
                        .cuboid(-4, -8, -4, 8, 8, 8, new Dilation(1.5F)),
                ModelTransform.NONE
        );

        ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.NONE);

        ears.addChild("ear1",
                ModelPartBuilder.create()
                        .uv(0, 16).cuboid(-1, -3, -1, 1, 4, 1)
                        .uv(4, 16).cuboid(0, -4, -1, 2, 5, 1),
                ModelTransform.of(-5, -9, 0.5F, 0, 0, -0.4363F));

        ears.addChild("ear2",
                ModelPartBuilder.create()
                        .uv(14, 16).cuboid(-2, -4, -1, 2, 5, 1)
                        .uv(20, 16).cuboid(0, -3, -1, 1, 4, 1),
                ModelTransform.of(5, -9, 0.5F, 0, 0, 0.4363F));

        return TexturedModelData.of(modelData, 64, 32);
    }
}
