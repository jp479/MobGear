package com.jp479.mobgear;

import com.jp479.mobgear.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MobGearDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MobGearRecipeProvider::new);
		pack.addProvider(MobGearMobLootTableProvider::new);
		pack.addProvider(MobGearBlockLootTableProvider::new);
		pack.addProvider(MobGearModelProvider::new);
		pack.addProvider(MobGearItemTagProvider::new);
		pack.addProvider(MobGearBlockTagProvider::new);
	}
}