package theoutback.core.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import theoutback.core.init.ItemInit;

public class TheOutbackItemGroup extends ItemGroup {

	public static final TheOutbackItemGroup THE_OUTBACK = new TheOutbackItemGroup(ItemGroup.TABS.length, "the_outback");

	public TheOutbackItemGroup(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.WITCHETTY_GRUB.get());
	}

}
