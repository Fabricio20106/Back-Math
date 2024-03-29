package com.sophicreeper.backmath.entity.custom;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.entity.BMEntities;
import com.sophicreeper.backmath.item.AxolotlTest;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class BMBoat extends BoatEntity {
    private static final DataParameter<String> WOOD_TYPE = EntityDataManager.createKey(BMBoat.class, DataSerializers.STRING);

    public BMBoat(EntityType<? extends BoatEntity> type, World world) {
        super(type, world);
        this.preventEntitySpawning = true;
    }

    public BMBoat(World world, double x, double y, double z) {
        this(BMEntities.BACK_MATH_BOAT.get(), world);
        this.setPosition(x, y, z);
        this.setMotion(Vector3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(WOOD_TYPE, "aljanwood");
    }

    @Override
    protected void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        this.setWoodType(tag.getString("Type"));
    }

    @Override
    protected void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putString("Type", this.getWoodType());
    }

    public String getWoodType() {
        return this.dataManager.get(WOOD_TYPE);
    }

    public void setWoodType(String wood) {
        this.dataManager.set(WOOD_TYPE, wood);
    }

    @Override
    public Item getItemBoat() {
        switch(this.getWoodType()) {
            case "aljanwood":
            default:
                return AxolotlTest.ALJANWOOD_BOAT.get();
            case "aljancap":
                return AxolotlTest.ALJANCAP_BOAT.get();
            case "insomnian":
                return AxolotlTest.INSOMNIAN_BOAT.get();
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(BackMath.resourceLoc(this.getWoodType() + "_boat")));
    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
