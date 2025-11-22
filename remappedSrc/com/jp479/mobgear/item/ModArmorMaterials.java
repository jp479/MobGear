package com.jp479.mobgear.item;

import com.jp479.mobgear.MobGear;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {
    public static final int BASE_DURABILITY = 5;

    public static final RegistryKey<EquipmentAsset> BAT_HELMET_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(MobGear.MOD_ID, "bat_ear"));
    public static final TagKey<Item> REPAIRS_BAT_HELMET = TagKey.of(Registries.ITEM.getKey(), Identifier.of(MobGear.MOD_ID, "repairs_bat_helmet"));

    public static final ArmorMaterial BAT_EAR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 1,
                    EquipmentType.CHESTPLATE, 3,
                    EquipmentType.LEGGINGS, 2,
                    EquipmentType.BOOTS, 1
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0f,
            0.0f,
            REPAIRS_BAT_HELMET,
            BAT_HELMET_MATERIAL_KEY
    );
}
