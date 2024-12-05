package com.sophicreeper.backmath.util.tag;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeTagHandler;

public class BMEnchantmentTags {
    public static final ITag.INamedTag<Enchantment> APPLICABLE_TO_SUMMONER_STAFF = backMath("applicable_to/queen_lucy_summoner_staff");
    public static final ITag.INamedTag<Enchantment> APPLICABLE_TO_BACK_MATH_BOWS = backMath("applicable_to/backmath_bows");
    public static final ITag.INamedTag<Enchantment> JANTIC_RAILGUN_NOT_APPLICABLE = backMath("jantic_railgun_not_applicable");

    private static ITag.INamedTag<Enchantment> backMath(String name) {
        return ForgeTagHandler.makeWrapperTag(new ResourceLocation("enchantment"), BackMath.backMath(name));
    }
}
