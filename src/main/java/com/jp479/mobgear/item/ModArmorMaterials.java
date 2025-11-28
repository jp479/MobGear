package com.jp479.mobgear.item;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {
    public static final int BAT_DURABILITY = 5;
    public static final int SLIME_DURABILITY = 20;
    public static final int MAGMA_CUBE_DURABILITY = 35;

    public static final RegistryKey<EquipmentAsset> BAT_HELMET_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(MobGear.MOD_ID, "bat_ear"));
    public static final RegistryKey<EquipmentAsset> SLIME_LEGGINGS_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(MobGear.MOD_ID, "slime_ball"));
    public static final RegistryKey<EquipmentAsset> MAGMA_CUBE_LEGGINGS_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(MobGear.MOD_ID, "magma_cream"));

    public static final ArmorMaterial BAT_EAR_MATERIAL = new ArmorMaterial(
            BAT_DURABILITY,
            Map.of(
                    EquipmentType.BODY, 3,
                    EquipmentType.HELMET, 1,
                    EquipmentType.CHESTPLATE, 3,
                    EquipmentType.LEGGINGS, 2,
                    EquipmentType.BOOTS, 1
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0f,
            0.0f,
            ModTags.Items.BAT_EAR_REPAIR,
            BAT_HELMET_MATERIAL_KEY
    );
    public static final ArmorMaterial SLIME_BALL_MATERIAL = new ArmorMaterial(
            SLIME_DURABILITY,
            Map.of(
                    EquipmentType.BODY, 5,
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 6,
                    EquipmentType.LEGGINGS, 5,
                    EquipmentType.BOOTS, 2
            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f,
            0.0f,
            ModTags.Items.SLIME_BALL_REPAIR,
            SLIME_LEGGINGS_MATERIAL_KEY
    );
    public static final ArmorMaterial MAGMA_CREAM_MATERIAL = new ArmorMaterial(
            MAGMA_CUBE_DURABILITY,
            Map.of(
                    EquipmentType.BODY, 11,
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0f,
            0.0f,
            ModTags.Items.MAGMA_CREAM_REPAIR,
            MAGMA_CUBE_LEGGINGS_MATERIAL_KEY
    );
}
