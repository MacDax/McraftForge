package com.mcexamples.objects.items;

import com.mcexamples.objects.entities.IronPistolBulletEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IronPistolBulletItem   extends Item {

    public IronPistolBulletItem(Properties properties) {
        super(properties);
    }


    public void onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        //ExampleMod.LOGGER.debug("Entering onItemRightClock()");
        ItemStack stack = playerIn.getItemInHand(handIn);
        if(worldIn.isClientSide)
        {
            IronPistolBulletEntity ironbullet = new IronPistolBulletEntity(playerIn, worldIn);
            ironbullet.setItem(stack);
            ironbullet.shoot(playerIn.getRotationVector().y, playerIn.getRotationVector().x, 0.0f, 1.5f, 1.0f);
        }
    }
}
