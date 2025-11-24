package com.jp479.mobgear.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import static net.minecraft.item.EnderPearlItem.POWER;

public class EndermanSword extends Item {
    public EndermanSword(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (world instanceof ServerWorld serverWorld) {
            ProjectileEntity.spawnWithVelocity(EnderPearlEntity::new, serverWorld, Items.ENDER_PEARL.getDefaultStack(), user, 0.0F, POWER, 1.0F);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        user.getItemCooldownManager().set(itemStack, 100);

        return ActionResult.SUCCESS;
    }
}
