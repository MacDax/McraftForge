package com.mcexamples.examplemod.objects.items;

import com.mcexamples.examplemod.objects.entities.SilverPistolBulletEntity;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SilverPistolBulletItem extends Item {

    public SilverPistolBulletItem(Properties properties) {
        super(properties);
    }

    public void onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack stack = playerIn.getItemInHand(handIn);
        if(worldIn.isClientSide)
        {
            SilverPistolBulletEntity silverbullet = new SilverPistolBulletEntity(playerIn, worldIn);
            silverbullet.setItem(stack);
            silverbullet.shoot(playerIn.getRotationVector().y, playerIn.getRotationVector().x, 0.0f, 1.5f, 1.0f);
        }
    }

}
