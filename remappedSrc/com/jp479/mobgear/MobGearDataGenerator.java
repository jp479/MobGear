package com.jp479.mobgear;

import com.jp479.mobgear.datagen.MobGearItemTagProvider;
import com.jp479.mobgear.datagen.MobGearMobLootTableProvider;
import com.jp479.mobgear.datagen.MobGearModelProvider;
import com.jp479.mobgear.datagen.MobGearRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MobGearDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MobGearItemTagProvider::new);
		pack.addProvider(MobGearRecipeProvider::new);
		pack.addProvider(MobGearMobLootTableProvider::new);
		pack.addProvider(MobGearModelProvider::new);
	}
}
