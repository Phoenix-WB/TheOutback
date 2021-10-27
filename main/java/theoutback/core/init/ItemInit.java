package theoutback.core.init;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import theoutback.TheOutback;
import theoutback.core.itemgroup.TheOutbackItemGroup;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TheOutback.MOD_ID);

	public static final RegistryObject<Item> WITCHETTY_GRUB = ITEMS.register("witchetty_grub",
			() -> new Item(new Item.Properties().tab(TheOutbackItemGroup.THE_OUTBACK)
					.food(new Food.Builder().nutrition(4).saturationMod(0.4f).fast().build())));

	public static final RegistryObject<Item> MALLEE_WOOD = ITEMS.register("mallee_wood",
			() -> new Item(new Item.Properties().tab(TheOutbackItemGroup.THE_OUTBACK)));
}