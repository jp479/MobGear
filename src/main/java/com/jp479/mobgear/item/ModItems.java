package com.jp479.mobgear.item;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.item.custom.BatHelmet;
import com.jp479.mobgear.item.custom.BlazePickaxe;
import com.jp479.mobgear.item.custom.BlazeSword;
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

import java.util.function.Function;

import static com.jp479.mobgear.item.ModFoodComponents.BAT_EAR_POISON_COMPONENT;
import static com.jp479.mobgear.item.ModFoodComponents.POISON_FOOD_COMPONENT;

public class ModItems {
    // Items
    public static final Item BAT_EAR = register(
            "bat_ear",
            Item::new,
            new Item.Settings().food(POISON_FOOD_COMPONENT, BAT_EAR_POISON_COMPONENT));
    public static final Item BLAZED_DIAMOND = register(
            "blazed_diamond",
            Item::new,
            new Item.Settings()
    );

    // Tools & Weapons
    public static final BlazeSword BLAZE_SWORD = (BlazeSword)  register(
            "blaze_sword",
            BlazeSword::new,
            new Item.Settings().sword(ModToolMaterials.BLAZE_DIAMOND_MATERIAL, 3.0f, -2.4f)
    );
    public static final BlazePickaxe BLAZE_PICKAXE = (BlazePickaxe) register(
            "blaze_pickaxe",
            BlazePickaxe::new,
            new Item.Settings().pickaxe(ModToolMaterials.BLAZE_DIAMOND_MATERIAL, 1.0f, -2.8f)
    );

    // Armor
    public static final BatHelmet BAT_HELMET = (BatHelmet) register(
            "bat_helmet",
            BatHelmet::new,
            new Item.Settings().armor(ModArmorMaterials.BAT_EAR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
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
        MobGear.LOGGER.info("Registering Mod Items for " + MobGear.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            // Items
            itemGroup.add(BAT_EAR);
            itemGroup.add(BLAZED_DIAMOND);

            // Tools & Weapons
            itemGroup.add(BLAZE_SWORD);
            itemGroup.add(BLAZE_PICKAXE);

            // Armor
            itemGroup.add(BAT_HELMET);
        });
    }
}