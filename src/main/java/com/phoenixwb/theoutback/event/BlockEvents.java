package com.phoenixwb.theoutback.event;

import java.util.Random;

import com.phoenixwb.theoutback.TheOutback;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheOutback.MODID)
public class BlockEvents {
	@SubscribeEvent
	public static void onRightClickWood(PlayerInteractEvent.RightClickBlock event) {
		if (!event.getLevel().isClientSide() && event.getLevel().getBlockState(event.getPos()).is(BlockTags.LOGS)) {
			ItemStack hand1 = event.getEntity().getItemInHand(InteractionHand.MAIN_HAND);
			ItemStack hand2 = event.getEntity().getItemInHand(InteractionHand.OFF_HAND);
			Random rand = new Random();
			if (event.getLevel().getBlockState(event.getPos()).is(BlockTags.LOGS_THAT_BURN)) {
				if (hand1.is(Items.STICK) && hand2.is(Items.STICK) && rand.nextInt(5) == 4) {
					event.getLevel().setBlock(event.getPos(), Blocks.CAMPFIRE.defaultBlockState(), 0);
				}
			} else {
				if (hand1.is(Items.BONE) && hand2.is(Items.BONE) && rand.nextInt(5) == 4) {
					event.getLevel().setBlock(event.getPos(), Blocks.CAMPFIRE.defaultBlockState(), 0);
				}
			}
		}
	}
}
