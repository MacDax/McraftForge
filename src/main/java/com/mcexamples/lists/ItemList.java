package com.mcexamples.lists;

import com.mcexamples.examplemod.ExampleMod;
import com.mcexamples.objects.items.IronPistolBulletItem;
import com.mcexamples.objects.items.SilverPistolBulletItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {

	

	    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);
	    
	    public static final RegistryObject<Item> SILVER_PISTOL_BULLET = ITEMS.register("silver_pistol_bullet", () -> new SilverPistolBulletItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
	    public static final RegistryObject<Item> IRON_PISTOL_BULLET = ITEMS.register("iron_pistol_bullet", () -> new IronPistolBulletItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
	}

