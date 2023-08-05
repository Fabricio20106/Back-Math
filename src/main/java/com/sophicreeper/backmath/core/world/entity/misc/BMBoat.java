package com.sophicreeper.backmath.core.world.entity.misc;

/*public class BMBoat extends BoatEntity {
    private static final DataParameter<String> WOOD_TYPE = EntityDataManager.createKey(BMBoat.class, DataSerializers.STRING);

    public BMBoat(EntityType<? extends BoatEntity> type, World world) {
        super(type, world);
        this.preventEntitySpawning = true;
    }

    public BMBoat(World world, double x, double y, double z) {
        this(BMEntities.BACKMATH_BOAT.get(), world);
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
    protected void readAdditional(CompoundNBT compoundNBT) {
        super.readAdditional(compoundNBT);
        compoundNBT.putString("Type", this.getWoodType());
    }

    @Override
    protected void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.putString("Type", this.getWoodType());
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
                return AxolotlTest.ALJANWOOD_BOAT.get();
            default:
                return AxolotlTest.ALJANWOOD_BOAT.get();
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
}*/
