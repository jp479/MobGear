package com.jp479.mobgear.util;

import com.jp479.mobgear.MobGear;
import com.jp479.mobgear.item.custom.BlazePickaxe;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class BlazePickaxeAutoSmeltHandler {
    public static void initialize() {
        MobGear.LOGGER.info("Registering blaze pickaxe auto smelt handler for " + MobGear.MOD_ID);

        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ItemStack tool = player.getMainHandStack();

            if (world.isClient()) {
                return true;
            }

            if (!(tool.getItem() instanceof BlazePickaxe)) {
                return true;
            }

            List<ItemStack> drops = Block.getDroppedStacks(
                    state,
                    (ServerWorld) world,
                    pos,
                    blockEntity,
                    player,
                    tool
            );

            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);

            for (ItemStack drop : drops) {
                int count = drop.getCount();

                ItemStack smeltedOne = trySmelt(new ItemStack(drop.getItem()), world);

                if (smeltedOne.getItem() != drop.getItem()) {
                    ItemStack smeltedStack = smeltedOne.copy();
                    smeltedStack.setCount(count);
                    Block.dropStack(world, pos, smeltedStack);
                } else {
                    Block.dropStack(world, pos, drop);
                }
            }

            return false;
        });
    }

    private static ItemStack trySmelt(ItemStack input, World world) {
        if (!(world instanceof ServerWorld serverWorld))
            return input;

        var recipeInput = new net.minecraft.recipe.input.SingleStackRecipeInput(input);

        Optional<RecipeEntry<SmeltingRecipe>> match =
                serverWorld.getRecipeManager().getFirstMatch(
                        RecipeType.SMELTING, recipeInput, serverWorld
                );

        if (match.isPresent()) {
            SmeltingRecipe recipe = match.get().value();
            ItemStack output = recipe.craft(recipeInput, serverWorld.getRegistryManager());

            return output.copy();
        }

        return input;
    }
}
