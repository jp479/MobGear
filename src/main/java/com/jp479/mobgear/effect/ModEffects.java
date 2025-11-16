package com.jp479.mobgear.effect;

import com.jp479.mobgear.MobGear;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static RegistryEntry<StatusEffect> ECHOLOCATION;

    private static StatusEffect register(String name, StatusEffect effect) {
        RegistryKey<StatusEffect> key = RegistryKey.of(
                RegistryKeys.STATUS_EFFECT,
                Identifier.of(MobGear.MOD_ID, name)
        );

        return Registry.register(Registries.STATUS_EFFECT, key, effect);
    }

    public static void initialize() {
        ECHOLOCATION = Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(MobGear.MOD_ID, "echolocation"),
                new EcholocationEffect()
        );
    }
}
