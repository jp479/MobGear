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

public class IronGolemChestplate extends Item {
    public IronGolemChestplate(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (slot != EquipmentSlot.CHEST) {
            return;
        }

        if (!(entity instanceof PlayerEntity player)) {
            return;
        }

        if (!world.isClient()) {
            applyResistanceEffect(player);
            applyStrengthEffect(player);
            applySlownessEffect(player);
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void applyResistanceEffect(PlayerEntity player) {
        StatusEffectInstance instance = new StatusEffectInstance(
                StatusEffects.RESISTANCE,
                10,
                2,
                false,
                false,
                false
        );

        player.addStatusEffect(instance);
    }

    private void applyStrengthEffect(PlayerEntity player) {
        StatusEffectInstance instance = new StatusEffectInstance(
                StatusEffects.STRENGTH,
                10,
                1,
                false,
                false,
                false
        );

        player.addStatusEffect(instance);
    }

    private void applySlownessEffect(PlayerEntity player) {
        StatusEffectInstance instance = new StatusEffectInstance(
                StatusEffects.SLOWNESS,
                10,
                2,
                false,
                false,
                false
        );

        player.addStatusEffect(instance);
    }
}
