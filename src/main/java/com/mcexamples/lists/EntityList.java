package com.mcexamples.lists;

import com.mcexamples.examplemod.ExampleMod;
import com.mcexamples.objects.entities.IronPistolBulletEntity;
import com.mcexamples.objects.entities.SilverPistolBulletEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityList{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, ExampleMod.MOD_ID);

    public static final RegistryObject<EntityType<SilverPistolBulletEntity>> SILVER_PISTOL_BULLET_PROJECTILE = ENTITIES.register("silver_pistol_bullet_projectile", () -> EntityType.Builder.<SilverPistolBulletEntity>of(SilverPistolBulletEntity::new, EntityClassification.MISC).sized(0.25f, 0.25f).build("silver_pistol_bullet_projectile"));
    public static final RegistryObject<EntityType<IronPistolBulletEntity>> IRON_PISTOL_BULLET_PROJECTILE = ENTITIES.register("iron_pistol_bullet_projectile", () -> EntityType.Builder.<IronPistolBulletEntity>of(IronPistolBulletEntity::new, EntityClassification.MISC).sized(0.25f, 0.25f).build("iron_pistol_bullet_projectile"));

}

