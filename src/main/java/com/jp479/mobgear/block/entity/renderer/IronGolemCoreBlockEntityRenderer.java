package com.jp479.mobgear.block.entity.renderer;

import com.jp479.mobgear.block.ModBlocks;
import com.jp479.mobgear.block.entity.custom.IronGolemCoreBlockEntity;
import com.jp479.mobgear.item.ModItems;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IronGolemCoreBlockEntityRenderer implements BlockEntityRenderer<IronGolemCoreBlockEntity, IronGolemCoreBlockEntityRenderState> {
    private final ItemModelManager itemModelManager;
    private static final ItemStack CORE_STACK =
            new ItemStack(ModBlocks.IRON_GOLEM_CORE);

    public IronGolemCoreBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.itemModelManager = context.itemModelManager();
    }

    @Override
    public IronGolemCoreBlockEntityRenderState createRenderState() {
        return new IronGolemCoreBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(IronGolemCoreBlockEntity blockEntity, IronGolemCoreBlockEntityRenderState state, float tickProgress,
                                  Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(
                blockEntity, state, tickProgress, cameraPos, crumblingOverlay
        );

        World world = blockEntity.getWorld();
        BlockPos pos = blockEntity.getPos();

        state.blockEntityWorld = world;
        state.lightPosition = pos;
        assert world != null;
        state.rotation = (world.getTime() + tickProgress) * 4f;

        // ✅ THE CORRECT CALL (1.21.10)
        this.itemModelManager.clearAndUpdate(
                state.itemRenderState,
                CORE_STACK,
                ItemDisplayContext.GROUND,
                world,
                null,   // no HeldItemContext
                pos.asLong() != 0 ? (int)pos.asLong() : 0
        );
    }

    @Override
    public void render(IronGolemCoreBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();

        matrices.translate(0.5, 1.1, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.rotation));
        matrices.scale(0.5f, 0.5f, 0.5f);

        state.itemRenderState.render(
                matrices,
                queue,
                getLightLevel(state.blockEntityWorld, state.lightPosition),
                OverlayTexture.DEFAULT_UV,
                0
        );

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
