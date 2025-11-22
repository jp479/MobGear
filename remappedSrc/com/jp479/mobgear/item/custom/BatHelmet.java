package com.jp479.mobgear.item.custom;

import com.jp479.mobgear.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class BatHelmet extends Item {
    public BatHelmet(net.minecraft.item.Item.Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (slot != EquipmentSlot.HEAD) {
            return;
        }

        if (!(entity instanceof PlayerEntity player)) {
            return;
        }

        if (!world.isClient()) {
            applyEcholocationEffect(player);
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void applyEcholocationEffect(PlayerEntity player) {
        StatusEffectInstance instance = new StatusEffectInstance(
                ModEffects.ECHOLOCATION,
                10,
                0,
                false,
                false,
                false
        );

        player.addStatusEffect(instance);
    }
}
