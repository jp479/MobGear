package com.jp479.mobgear.block.entity;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.block.ModBlocks;
import com.jp479.mobgear.block.entity.custom.IronGolemCoreBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<IronGolemCoreBlockEntity> IRON_GOLEM_CORE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MobGear.MOD_ID, "iron_golem_core_be"),
                    FabricBlockEntityTypeBuilder.create(IronGolemCoreBlockEntity::new, ModBlocks.IRON_GOLEM_CORE).build(null));

    public static void initialize() {
        MobGear.LOGGER.info("Registering block entities for " + MobGear.MOD_ID);
    }
}
