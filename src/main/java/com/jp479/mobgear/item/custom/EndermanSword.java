package com.jp479.mobgear.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class EndermanSword extends RangedWeaponItem {
    private static final float MAX_TELEPORT_DISTANCE = 10.0f;

    public EndermanSword(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {

    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return ActionResult.CONSUME;
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) return false;
        if (world.isClient()) return true;

        int useTicks = getMaxUseTime(stack, user) - remainingUseTicks;
        float pull = getPullProgress(useTicks);

        if (pull < 0.1F) return false;

        float distance = pull * MAX_TELEPORT_DISTANCE;

        Vec3d start = player.getCameraPosVec(1.0F);
        Vec3d direction = player.getRotationVec(1.0F);
        Vec3d end = start.add(direction.multiply(distance));

        ServerWorld serverWorld = (ServerWorld) world;

        BlockHitResult hit = serverWorld.raycast(new RaycastContext(
                start,
                end,
                RaycastContext.ShapeType.COLLIDER,
                RaycastContext.FluidHandling.NONE,
                player
        ));

        Vec3d targetPos;

        if (hit.getType() == HitResult.Type.BLOCK) {
            targetPos = hit.getPos().add(0, 0.1, 0);
        } else {
            targetPos = end;
        }

        player.requestTeleport(targetPos.x, targetPos.y, targetPos.z);

        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ENTITY_ENDERMAN_TELEPORT,
                SoundCategory.PLAYERS,
                1.0F,
                1.0F
        );

        serverWorld.spawnParticles(
                ParticleTypes.PORTAL,
                targetPos.x,
                targetPos.y + 1,
                targetPos.z,
                64,
                0.5, 1.0, 0.5,
                0.3
        );

        player.getItemCooldownManager().set(stack, 100);
        stack.damage(1, player);
        player.incrementStat(Stats.USED.getOrCreateStat(this));

        return true;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    private static float getPullProgress(int useTicks) {
        float f = (float) useTicks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        return Math.min(f, 1.0F);
    }
}
