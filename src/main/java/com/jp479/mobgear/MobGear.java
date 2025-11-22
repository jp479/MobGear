package com.jp479.mobgear;

import com.jp479.mobgear.block.ModBlocks;
import com.jp479.mobgear.effect.ModEffects;
import com.jp479.mobgear.item.ModItems;
import com.jp479.mobgear.util.BlazePickaxeAutoSmeltHandler;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobGear implements ModInitializer {
	public static final String MOD_ID = "mobgear";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
		ModEffects.initialize();
		BlazePickaxeAutoSmeltHandler.initialize();
	}
}
