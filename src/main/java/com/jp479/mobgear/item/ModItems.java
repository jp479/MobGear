package com.jp479.mobgear.item;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.block.ModBlocks;
import com.jp479.mobgear.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

import static com.jp479.mobgear.item.ModFoodComponents.*;

public class ModItems {
    // Items
    public static final Item BAT_EAR = register(
            "bat_ear",
            Item::new,
            new Item.Settings().food(POISON_FOOD_COMPONENT, BAT_EAR_POISON_COMPONENT));
    public static final Item OCELOT_PAW = register(
            "ocelot_paw",
            Item::new,
            new Item.Settings().food(SLOWNESS_FOOD_COMPONENT, OCELOT_PAW_SLOWNESS_COMPONENT)
    );
    public static final Item WITHER_BONE = register(
            "wither_bone",
            Item::new,
            new Item.Settings()
    );
    public static final Item CHORUS_STICK = register(
            "chorus_stick",
            Item::new,
            new Item.Settings()
    );
    public static final Item BLAZED_DIAMOND = register(
            "blazed_diamond",
            Item::new,
            new Item.Settings()
    );
    public static final Item ENDER_IRON_INGOT = register(
            "ender_iron_ingot",
            Item::new,
            new Item.Settings()
    );

    // Tools & Weapons
    public static final BlazeSword BLAZE_SWORD = (BlazeSword)  register(
            "blaze_sword",
            BlazeSword::new,
            new Item.Settings().sword(ModToolMaterials.BLAZE_DIAMOND_MATERIAL, 3.0f, -2.4f)
                    .rarity(Rarity.EPIC)
    );
    public static final EndermanSword ENDERMAN_SWORD = (EndermanSword) register(
            "enderman_sword",
            EndermanSword::new,
            new Item.Settings().sword(ModToolMaterials.ENDER_IRON_MATERIAL, 3.0f, -2.4f)
                    .rarity(Rarity.EPIC)
    );
    public static final BlazePickaxe BLAZE_PICKAXE = (BlazePickaxe) register(
            "blaze_pickaxe",
            BlazePickaxe::new,
            new Item.Settings().pickaxe(ModToolMaterials.BLAZE_DIAMOND_MATERIAL, 1.0f, -2.8f)
                    .rarity(Rarity.EPIC)
    );
    public static final SkeletonBow SKELETON_BOW = (SkeletonBow) register(
            "skeleton_bow",
            SkeletonBow::new,
            new Item.Settings().maxDamage(448).enchantable(1)
                    .rarity(Rarity.RARE)
    );
    public static final WitherSkeletonBow WITHER_SKELETON_BOW = (WitherSkeletonBow) register(
            "wither_skeleton_bow",
            WitherSkeletonBow::new,
            new Item.Settings().maxDamage(512).enchantable(1)
                    .rarity(Rarity.EPIC)
    );

    // Armor
    public static final BatHelmet BAT_HELMET = (BatHelmet) register(
            "bat_helmet",
            BatHelmet::new,
            new Item.Settings().armor(ModArmorMaterials.BAT_EAR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BAT_DURABILITY))
                    .rarity(Rarity.UNCOMMON)
    );
    public static final SlimeLeggings SLIME_LEGGINGS = (SlimeLeggings) register(
            "slime_leggings",
            SlimeLeggings::new,
            new Item.Settings().armor(ModArmorMaterials.SLIME_BALL_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.SLIME_DURABILITY))
                    .rarity(Rarity.RARE)
    );
    public static final MagmaCubeLeggings MAGMA_CUBE_LEGGINGS = (MagmaCubeLeggings) register(
            "magma_cube_leggings",
            MagmaCubeLeggings::new,
            new Item.Settings().armor(ModArmorMaterials.MAGMA_CREAM_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.MAGMA_CUBE_DURABILITY))
                    .rarity(Rarity.EPIC)
    );
    public static final OcelotBoots OCELOT_BOOTS = (OcelotBoots) register(
            "ocelot_boots",
            OcelotBoots::new,
            new Item.Settings().armor(ModArmorMaterials.OCELOT_PAW_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.OCELOT_DURABILITY))
                    .rarity(Rarity.UNCOMMON)
    );

    // Item group
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MobGear.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BAT_HELMET))
            .displayName(Text.translatable("itemGroup.mobgear"))
            .build();

    // Register method
    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MobGear.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    // Initializing method
    public static void initialize() {
        MobGear.LOGGER.info("Registering mod items for " + MobGear.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            // Blocks
            itemGroup.add(ModBlocks.BLAZED_DIAMOND_BLOCK);
            itemGroup.add(ModBlocks.ENDER_IRON_BLOCK);

            // Items
            itemGroup.add(BAT_EAR);
            itemGroup.add(OCELOT_PAW);
            itemGroup.add(WITHER_BONE);
            itemGroup.add(CHORUS_STICK);
            itemGroup.add(BLAZED_DIAMOND);
            itemGroup.add(ENDER_IRON_INGOT);

            // Tools & Weapons
            itemGroup.add(BLAZE_SWORD);
            itemGroup.add(ENDERMAN_SWORD);
            itemGroup.add(BLAZE_PICKAXE);
            itemGroup.add(SKELETON_BOW);
            itemGroup.add(WITHER_SKELETON_BOW);

            // Armor
            itemGroup.add(BAT_HELMET);
            itemGroup.add(SLIME_LEGGINGS);
            itemGroup.add(MAGMA_CUBE_LEGGINGS);
            itemGroup.add(OCELOT_BOOTS);
        });
    }
}
