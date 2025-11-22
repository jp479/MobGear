package com.jp479.mobgear.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class EcholocationEffect extends StatusEffect {
    public EcholocationEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFFFFFF);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        entity.addStatusEffect(new StatusEffectInstance(
                net.minecraft.entity.effect.StatusEffects.BLINDNESS,
                60,
                0,
                false,
                false,
                false
        ));

        List<MobEntity> mobs = world.getEntitiesByClass(
                MobEntity.class,
                entity.getBoundingBox().expand(50),
                mob -> mob.isAlive()
        );

        for (MobEntity mob : mobs) {
            mob.addStatusEffect(new StatusEffectInstance(
                    net.minecraft.entity.effect.StatusEffects.GLOWING,
                    20,
                    0,
                    false,
                    false
            ));
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
