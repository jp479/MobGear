package com.jp479.mobgear.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class MagmaCubeLeggings extends Item {
    public MagmaCubeLeggings(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (slot != EquipmentSlot.LEGS) {
            return;
        }

        if (!(entity instanceof PlayerEntity player)) {
            return;
        }

        if (!world.isClient()) {
            applyJumpBoostEffect(player);
            applyFireResistanceEffect(player);
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void applyJumpBoostEffect(PlayerEntity player) {
        StatusEffectInstance instance = new StatusEffectInstance(
                StatusEffects.JUMP_BOOST,
                10,
                4,
                false,
                false,
                false
        );

        player.addStatusEffect(instance);
    }

    private void applyFireResistanceEffect(PlayerEntity player) {
        StatusEffectInstance instance = new StatusEffectInstance(
                StatusEffects.FIRE_RESISTANCE,
                10,
                0,
                false,
                false,
                false
        );

        player.addStatusEffect(instance);
    }
}
