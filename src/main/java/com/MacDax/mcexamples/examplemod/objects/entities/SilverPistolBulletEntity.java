package com.MacDax.mcexamples.examplemod.objects.entities;

import com.MacDax.mcexamples.examplemod.lists.EntityList;
import com.MacDax.mcexamples.examplemod.lists.ItemList;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SilverPistolBulletEntity extends ProjectileItemEntity
{
    public SilverPistolBulletEntity(EntityType<SilverPistolBulletEntity> type, World world)
    {
        super(type, world);

    }

    public SilverPistolBulletEntity(LivingEntity entity, World world)
    {
        super(EntityList.SILVER_PISTOL_BULLET_PROJECTILE.get(), entity, world);
    }

    public SilverPistolBulletEntity(double x, double y, double z, World world)
    {
        super(EntityList.SILVER_PISTOL_BULLET_PROJECTILE.get(), x, y, z, world );
    }

    @Override
    protected Item getDefaultItem() {
        return ItemList.SILVER_PISTOL_BULLET.get();
    }


    @Override
    public IPacket<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        this.remove();
    }


}
