package theoutback.common.events;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import theoutback.TheOutback;

@EventBusSubscriber(modid = TheOutback.MOD_ID, bus = Bus.FORGE)
public class PlayerEvents {
	@SubscribeEvent
	public static void fireLighter(PlayerInteractEvent.RightClickBlock event) {
		ItemStack stick = event.getItemStack();
		PlayerEntity player = event.getPlayer();
		BlockPos blockpos = event.getHitVec().getBlockPos();
		if (stick.getItem() == Items.FLINT_AND_STEEL) {
			BlockState clickedBlock = event.getWorld().getBlockState(blockpos);
			if (clickedBlock.getBlock().is(BlockTags.LOGS_THAT_BURN)) {
				player.level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
						1.0F);
					event.getWorld().setBlockAndUpdate(blockpos, Blocks.CAMPFIRE.defaultBlockState());
					player.level.playSound(player, blockpos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F,
							1.0F);
			}
			if (clickedBlock.getBlock() == Blocks.CRIMSON_STEM || clickedBlock.getBlock() == Blocks.WARPED_STEM) {
				player.level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
						1.0F);
					event.getWorld().setBlockAndUpdate(blockpos, Blocks.SOUL_CAMPFIRE.defaultBlockState());
					player.level.playSound(player, blockpos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F,
							1.0F);
			}
		}
		if (stick.getItem() == Items.STICK) {
			BlockState clickedBlock = event.getWorld().getBlockState(blockpos);
			Random rand = new Random();
			if (clickedBlock.getBlock().is(BlockTags.LOGS_THAT_BURN)) {
				player.level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
						1.0F);
				if (rand.nextInt(6) == 1) {
					event.getWorld().setBlockAndUpdate(blockpos, Blocks.CAMPFIRE.defaultBlockState());
					player.level.playSound(player, blockpos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F,
							1.0F);
				}
				if (rand.nextInt(4) == 1) {
					player.level.playSound(player, blockpos, SoundEvents.ITEM_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
					player.broadcastBreakEvent(event.getHand());
					stick.shrink(1);
				}
			}
		}
		if (stick.getItem() == Items.BONE)

		{
			BlockState clickedBlock = event.getWorld().getBlockState(blockpos);
			Random rand = new Random();
			if (clickedBlock.getBlock() == Blocks.CRIMSON_STEM || clickedBlock.getBlock() == Blocks.WARPED_STEM) {
				player.level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
						1.0F);
				if (rand.nextInt(6) == 1) {
					event.getWorld().setBlockAndUpdate(blockpos, Blocks.SOUL_CAMPFIRE.defaultBlockState());
					player.level.playSound(player, blockpos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F,
							1.0F);
				}
				if (rand.nextInt(4) == 1) {
					player.level.playSound(player, blockpos, SoundEvents.ITEM_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
					player.broadcastBreakEvent(event.getHand());
					stick.shrink(1);
				}
			}
		}
	}
}
