package com.sophicreeper.backmath.data.models;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.block.custom.EmotionalSquidBlock;
import com.sophicreeper.backmath.block.custom.GrapeVinePostBlock;
import com.sophicreeper.backmath.crystallizer.CrystallizerBlock;
import com.sophicreeper.backmath.crystallizer.Molds;
import com.sophicreeper.backmath.crystallizer.advanced.AdvancedMolds;
import com.sophicreeper.backmath.crystallizer.advanced.CrystallineCrystallizerBlock;
import com.sophicreeper.backmath.data.BlockFamilyProvider;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.loaders.MultiLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public abstract class BMBlockStateModels extends BlockStateProvider {
    public BMBlockStateModels(DataGenerator generator, String modID, ExistingFileHelper fileHelper) {
        super(generator, modID, fileHelper);
    }

    public void simplePlantWithPotted(Block block, Block pottedBlock, ResourceLocation texture) {
        simpleBlock(block, models().cross(block.getRegistryName().getPath(), texture));
        simpleBlock(pottedBlock, models().withExistingParent(pottedBlock.getRegistryName().getPath(), "block/flower_pot_cross").texture("plant", texture));
    }

    public void leaves(Block leaves, ResourceLocation texture) {
        simpleBlock(leaves, models().withExistingParent(leaves.getRegistryName().getPath(), mcLoc("block/leaves")).texture("all", texture));
    }

    public void fruitLeaves(Block leaves, ResourceLocation leavesTexture, ResourceLocation fruitTexture) {
        simpleBlock(leaves, models().withExistingParent(leaves.getRegistryName().getPath(), modLoc("block/template_fruit_leaves")).texture("leaf", leavesTexture).texture("fruit", fruitTexture));
    }

    public void fluid(Block block, ResourceLocation stillTexture) {
        simpleBlock(block, models().getBuilder(block.getRegistryName().getPath()).texture("particle", stillTexture));
    }

    public ModelBuilder<BlockModelBuilder> wallTorch(String name, ResourceLocation torch) {
        return models().singleTexture(name, mcLoc("block/wall_torch"), "torch", torch);
    }

    public void ladder(Block ladder) {
        getVariantBuilder(ladder).forAllStatesExcept(state -> ConfiguredModel.builder().modelFile(models().withExistingParent(ladder.getRegistryName().getPath(), modLoc("block/template_ladder")).texture("ladder", modLoc("block/" + ladder.getRegistryName()
                .getPath()))).rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite().toYRot()).build(), BlockStateProperties.WATERLOGGED);
    }

    public void chain(Block chain) {
        getVariantBuilder(chain).forAllStatesExcept(state -> {
            Direction.Axis axis = state.getValue(ChainBlock.AXIS);

            return ConfiguredModel.builder().modelFile(models().withExistingParent(chain.getRegistryName().getPath(), modLoc("block/template_chain")).texture("chain", modLoc("block/" + chain.getRegistryName().getPath()))).rotationX(axis == Direction.Axis.X ||
                    axis == Direction.Axis.Z ? 90 : 0).rotationY(axis == Direction.Axis.X ? 90 : 0).build();
        }, BlockStateProperties.WATERLOGGED);
    }

    public void charjanTorch(Block standingTorch, Block wallTorch, String material) {
        simpleBlock(standingTorch, models().torch("charjan_" + material + "_torch", modLoc("block/charjan_" + material + "_torch")));
        getVariantBuilder(wallTorch).forAllStates(state -> ConfiguredModel.builder().modelFile(wallTorch("charjan_" + material + "_wall_torch", modLoc("block/charjan_" + material + "_torch"))).rotationY((int) state.getValue(
                BlockStateProperties.HORIZONTAL_FACING).toYRot() + 90).build());
    }

    public void lantern(Block lantern, boolean usesMidTermModel) {
        ModelFile standingLantern = models().withExistingParent(lantern.getRegistryName().getPath(), usesMidTermModel ? modLoc("block/template_mid_term_lantern") : mcLoc("block/template_lantern")).texture("lantern", "block/" + lantern.getRegistryName().getPath());
        ModelFile hangingLantern = models().withExistingParent(lantern.getRegistryName().getPath() + "_hanging", usesMidTermModel ? modLoc("block/template_hanging_mid_term_lantern") : mcLoc("block/template_hanging_lantern")).texture("lantern", "block/" + lantern.getRegistryName().getPath());

        getVariantBuilder(lantern).forAllStatesExcept(state -> ConfiguredModel.builder().modelFile(state.getValue(LanternBlock.HANGING) ? hangingLantern : standingLantern).build(), BlockStateProperties.WATERLOGGED);
    }

    public void grapeVinePost(Block block, ResourceLocation postTexture) {
        ModelFile notGrown = grapeVinePost(block.getRegistryName().getPath() + "_age0", BackMath.backMath("block/hanging_grape_vines_age0"), postTexture);
        ModelFile preGrown = grapeVinePost(block.getRegistryName().getPath() + "_age1", BackMath.backMath("block/hanging_grape_vines_age1"), postTexture);
        ModelFile grown = grapeVinePost(block.getRegistryName().getPath() + "_age2", BackMath.backMath("block/hanging_grape_vines_age2"), postTexture);
        this.grapeVinePost((GrapeVinePostBlock) block, notGrown, preGrown, grown);
    }

    public void grapeVinePost(GrapeVinePostBlock block, ModelFile notGrown, ModelFile preGrown, ModelFile grown) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction facing = state.getValue(GrapeVinePostBlock.FACING);
            int age = state.getValue(GrapeVinePostBlock.AGE);
            return ConfiguredModel.builder().modelFile(age == 0 || age == 1 ? notGrown : (age == 2 ? preGrown : grown)).rotationY((int) facing.toYRot()).build();
        }, BlockStateProperties.WATERLOGGED);
    }

    public void grassBlock(Block block, ResourceLocation baseTexture, ResourceLocation bottomTexture) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean snowy = state.getValue(GrassBlock.SNOWY);
            ModelFile model = models().withExistingParent(block.getRegistryName().getPath() + (snowy ? "_snowy" : ""), snowy ? "minecraft:block/cube_bottom_top" : "backmath:block/template_grass_block").texture("bottom", bottomTexture).texture("top", baseTexture + "_top").texture(
                    "side", baseTexture + "_side" + (snowy ? "_snowy" : "")).texture("overlay", baseTexture + "_side_overlay");
            return ConfiguredModel.builder().modelFile(model).nextModel().modelFile(model).rotationY(90).nextModel().modelFile(model).rotationY(180).nextModel().modelFile(model).rotationY(270).build();
        });
    }

    public void crystallizer(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            Direction facing = state.getValue(HorizontalBlock.FACING);
            Molds mold = state.getValue(CrystallizerBlock.MOLD);
            int rotation = (int) facing.getOpposite().toYRot();
            return ConfiguredModel.builder().modelFile(models().withExistingParent(block.getRegistryName().getPath() + "_" + mold + "_mold", modLoc("block/template_crystallizer")).texture("top", modLoc("block/" + block.getRegistryName().getPath() +
                    "_top_" + mold.getSerializedName()))).rotationY(rotation == 360 ? 0 : rotation).build();
        });
    }

    public void crystallineCrystallizer(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            Direction facing = state.getValue(HorizontalBlock.FACING);
            AdvancedMolds mold = state.getValue(CrystallineCrystallizerBlock.MOLD);
            int rotation = (int) facing.getOpposite().toYRot();
            return ConfiguredModel.builder().modelFile(models().withExistingParent(block.getRegistryName().getPath() + "_" + mold + "_mold", modLoc("block/template_crystalline_crystallizer")).texture("mold", modLoc("block/crystallizer_top_" +
                    mold.getSerializedName()))).rotationY(rotation == 360 ? 0 : rotation).build();
        });
    }

    public void emotionalSquid(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction facing = state.getValue(HorizontalBlock.FACING);
            boolean hanging = state.getValue(EmotionalSquidBlock.HANGING);
            String hangingAddition = hanging ? "hanging_" : "";
            return ConfiguredModel.builder().modelFile(models().withExistingParent(block.getRegistryName().getPath() + (hanging ? "_hanging" : ""), modLoc("block/template_" + hangingAddition + "emotional_squid")).texture("squid", modLoc("block/" + block
                    .getRegistryName().getPath()))).rotationY((int) facing.getOpposite().toYRot()).build();
        }, BlockStateProperties.WATERLOGGED);
    }

    public void toy(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction facing = state.getValue(HorizontalBlock.FACING);
            return ConfiguredModel.builder().modelFile(models().withExistingParent(block.getRegistryName().getPath(), modLoc("block/template_toy")).texture("toy", modLoc("block/" + block.getRegistryName().getPath()))).rotationY((int) facing.getOpposite()
                    .toYRot()).build();
        }, BlockStateProperties.WATERLOGGED);
    }

    public void bag(Block block) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String path = block.getRegistryName().getPath();
            Direction facing = state.getValue(HorizontalBlock.FACING);
            return ConfiguredModel.builder().modelFile(models().withExistingParent(path, modLoc("block/template_placed_bag")).texture("part_one", modLoc("block/" + path + "_a")).texture("part_two", modLoc("block/" + path + "_b")).texture(
                    "particle", modLoc("block/" + path + "_particle"))).rotationY((int) facing.getOpposite().toYRot()).build();
        }, BlockStateProperties.WATERLOGGED);
    }

    public void cake(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            String path = block.getRegistryName().getPath();
            int bites = state.getValue(BlockStateProperties.BITES);
            String bite = bites == 0 ? "" : "_slice" + bites;
            ModelFile eatenCake = models().withExistingParent(path + bite, modLoc("block/template_cake" + bite)).texture("inside", modLoc("block/" + path + "_inner")).texture("side", modLoc("block/" + path + "_side")).texture("bottom", modLoc("block/" + path + "_bottom")).texture("top", modLoc("block/" + path + "_top"));
            return ConfiguredModel.builder().modelFile(eatenCake).build();
        });
    }

    public void wheatIndexCrop(Block block, Block wildCrop, String texture) {
        getVariantBuilder(block).forAllStates(state -> {
            int cropAgeIndex = wheatAgeIndex(state.getValue(CropsBlock.AGE));
            return ConfiguredModel.builder().modelFile(models().crop(texture + "_stage" + cropAgeIndex, modLoc("block/" + texture + "_stage" + cropAgeIndex))).build();
        });
        simpleBlock(wildCrop, models().withExistingParent("wild_" + texture, modLoc("block/template_wild_crop")).texture("crop", "block/wild_" + texture));
    }

    public void potatoIndexCrop(Block block, Block wildCrop, String texture) {
        getVariantBuilder(block).forAllStates(state -> {
            int cropAgeIndex = potatoAgeIndex(state.getValue(CropsBlock.AGE));
            return ConfiguredModel.builder().modelFile(models().crop(texture + "_stage" + cropAgeIndex, modLoc("block/" + texture + "_stage" + cropAgeIndex))).build();
        });
        simpleBlock(wildCrop, models().withExistingParent("wild_" + texture, modLoc("block/template_wild_crop")).texture("crop", "block/wild_" + texture));
    }

    public void head(Block block) {
        simpleBlock(block, models().getBuilder(block.getRegistryName().getPath()).parent(models().getExistingFile(modLoc("item/template_head"))));
    }

    public void insomnianTulip(Block block) {
        String path = block.getRegistryName().getPath();

        simpleBlock(block, models().getBuilder(block.getRegistryName().getPath()).texture("particle", modLoc("block/" + path)).ao(false)
                .customLoader(MultiLayerModelBuilder::begin)
                .submodel(RenderType.cutout(), models().nested().parent(models().getExistingFile(mcLoc("block/cross"))).texture("cross", modLoc("block/" + path)))
                .submodel(RenderType.translucent(), models().nested().parent(models().getExistingFile(mcLoc("block/cross"))).texture("cross", modLoc("block/" + path + "_overlay"))).end());
    }

    public BlockFamilyProvider blockFamily(ResourceLocation texture, String materialName) {
        return new BlockFamilyProvider(this, materialName, texture);
    }

    private ModelFile grapeVinePost(String name, ResourceLocation vinesTexture, ResourceLocation postTexture) {
        return models().withExistingParent(name, BackMath.backMath("block/template_grape_vine_post_v2")).texture("post", postTexture).texture("vines", vinesTexture);
    }

    public static int potatoAgeIndex(int age) {
        if (age > 6) return 3;
        if (age > 3) return 2;
        if (age > 1) return 1;
        return 0;
    }

    public static int wheatAgeIndex(int age) {
        if (age > 7) return 0;
        return age;
    }

    public static String moistIndex(int moistLevel) {
        if (moistLevel != 7) return "";
        return "_moist";
    }
}
