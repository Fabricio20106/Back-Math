package com.sophicreeper.backmath.util.fix;

import com.sophicreeper.backmath.misc.BMRegistries;
import com.sophicreeper.backmath.util.TagTypes;
import com.sophicreeper.backmath.variant.queenlucypet.BMQueenLucyPetVariants;
import com.sophicreeper.backmath.variant.queenlucypet.QueenLucyPetVariant;
import com.sophicreeper.backmath.variant.wansophie.BMWandererSophieVariants;
import com.sophicreeper.backmath.variant.wansophie.WandererSophieVariant;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;

public class BMTagFixes {
    // Updates the old "SpellTicks" tag of Queen Lucies to the new "lucy_spells.spell_cooldown_ticks" tag.
    public static int fixSpellTicksTag(CompoundNBT tag) {
        CompoundNBT lucySpells = tag.getCompound("lucy_spells");
        if (!lucySpells.contains("spell_cooldown_ticks") || tag.contains("SpellTicks")) {
            lucySpells.putInt("spell_cooldown_ticks", tag.getInt("SpellTicks"));
            tag.remove("SpellTicks");
        }
        return lucySpells.getInt("spell_cooldown_ticks");
    }

    // Updates the old "Inventory" tag of Archer Lucias to the new "inventory" tag.
    public static ListNBT fixInventoryTag(CompoundNBT tag) {
        if (tag.contains("Inventory")) {
            tag.put("inventory", tag.getList("Inventory", TagTypes.COMPOUND));
            tag.remove("Inventory");
        }
        return tag.getList("inventory", TagTypes.COMPOUND);
    }

    // Updates the old "CanBreakDoors" tag of Insomnia Zombies and Zombie Fabricios to the new "can_break_doors" tag.
    public static boolean fixCanBreakDoorsTag(CompoundNBT tag) {
        if (tag.contains("CanBreakDoors")) {
            tag.putBoolean("can_break_doors", tag.getBoolean("CanBreakDoors"));
            tag.remove("CanBreakDoors");
        }
        return tag.getBoolean("can_break_doors");
    }

    // Updates the old "Size" tag of Amaracamelers to the new "size" tag.
    public static int fixSizeTag(CompoundNBT tag) {
        if (tag.contains("Size")) {
            tag.putInt("size", tag.getInt("Size"));
            tag.remove("Size");
        }
        return tag.getInt("size");
    }

    // Updates the old "wasOnGround" tag of Amaracamelers to the new "was_on_ground" tag.
    public static boolean fixWasOnGroundTag(CompoundNBT tag) {
        if (tag.contains("wasOnGround")) {
            tag.putBoolean("was_on_ground", tag.getBoolean("wasOnGround"));
            tag.remove("wasOnGround");
        }
        return tag.getBoolean("was_on_ground");
    }

    // Updates the old "Variant" (integer) and tag of Wanderer Sophies to the new "variant" (registry) tag.
    public static WandererSophieVariant fixWandererSophieVariantTag(CompoundNBT tag) {
        tag.remove("variant_reg");
        if (tag.contains("Variant")) {
            switch (tag.getInt("Variant")) {
                case 1:
                    return BMWandererSophieVariants.CYAN_AXOLOTL.get();
                case 2:
                    return BMWandererSophieVariants.CREEPER.get();
                case 3:
                    return BMWandererSophieVariants.MODIFIED.get();
                case 4:
                    return BMWandererSophieVariants.ORIGINAL.get();
                case 5:
                    return BMWandererSophieVariants.SAVANNAH.get();
                case 6:
                    return BMWandererSophieVariants.BRAZIL_SHIRT.get();
                case 7:
                    return BMWandererSophieVariants.PAJAMA.get();
                case 8:
                    return BMWandererSophieVariants.WITCHER.get();
                case 9:
                    return BMWandererSophieVariants.MAID.get();
                case 10:
                    return BMWandererSophieVariants.ENDER.get();
                case 12:
                    return BMWandererSophieVariants.WORKER.get();
                case 13:
                    return BMWandererSophieVariants.BLUE_AXOLOTL.get();
                case 14:
                    return BMWandererSophieVariants.CYAN_AXOLOTL_2.get();
                case 15:
                    return BMWandererSophieVariants.EMPRESARY2.get();
                case 16:
                    return BMWandererSophieVariants.ENTREPRENEUR.get();
                default:
                case 0:
                    return BMWandererSophieVariants.YELLOW_AXOLOTL.get();
            }
        }
        return BMRegistries.WANDERER_SOPHIE_VARIANT.getValue(ResourceLocation.tryParse(tag.getString("variant")));
    }

    // Updates the old "Variant" (integer) and tag of Wanderer Sophies to the new "variant" (registry) tag.
    public static QueenLucyPetVariant fixQueenLucyPetVariantTag(CompoundNBT tag) {
        if (tag.contains("Variant")) {
            switch (tag.getInt("Variant")) {
                case 1:
                    return BMQueenLucyPetVariants.ALTERNATE.get();
                case 2:
                    return BMQueenLucyPetVariants.RELIC.get();
                case 3:
                    return BMQueenLucyPetVariants.SHY_FABRICIO.get();
                case 4:
                    return BMQueenLucyPetVariants.SV_ORIGINAL.get();
                case 5:
                    return BMQueenLucyPetVariants.SV_MODIFIED.get();
                case 6:
                    return BMQueenLucyPetVariants.SV_CREEPER.get();
                case 7:
                    return BMQueenLucyPetVariants.SV_BRAZIL_SHIRT.get();
                case 8:
                    return BMQueenLucyPetVariants.SV_PAJAMA.get();
                case 9:
                    return BMQueenLucyPetVariants.SV_SAVANNAH.get();
                case 10:
                    return BMQueenLucyPetVariants.SV_WITCHER.get();
                case 12:
                    return BMQueenLucyPetVariants.SV_MAID.get();
                case 13:
                    return BMQueenLucyPetVariants.SV_YELLOW_AXOLOTL.get();
                case 14:
                    return BMQueenLucyPetVariants.SV_CYAN_AXOLOTL.get();
                case 15:
                    return BMQueenLucyPetVariants.SV_ENDER.get();
                case 16:
                    return BMQueenLucyPetVariants.SV_WORKER.get();
                case 17:
                    return BMQueenLucyPetVariants.SV_EMPRESARY2.get();
                case 18:
                    return BMQueenLucyPetVariants.SV_ENTREPRENEUR.get();
                case 19:
                    return BMQueenLucyPetVariants.SV_BLUE_AXOLOTL.get();
                case 20:
                    return BMQueenLucyPetVariants.SV_CYAN_AXOLOTL_2.get();
                default:
                case 0:
                    return BMQueenLucyPetVariants.CURRENT.get();
            }
        }
        return BMRegistries.QUEEN_LUCY_PET_VARIANT.getValue(ResourceLocation.tryParse(tag.getString("variant")));
    }
}
