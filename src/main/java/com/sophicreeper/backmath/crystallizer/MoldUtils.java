package com.sophicreeper.backmath.crystallizer;

import com.sophicreeper.backmath.crystallizer.advanced.AdvancedMolds;

public class MoldUtils {
    public static Molds getMoldFromString(String mold) {
        switch (mold) {
            case "singularity":
                return Molds.SINGULARITY;
            case "crystallized":
                return Molds.CRYSTALLIZED;
            case "ingot":
                return Molds.INGOT;
            case "mold":
                return Molds.MOLD;
            case "rod":
                return Molds.ROD;
            default:
                return Molds.EMPTY;
        }
    }

    public static AdvancedMolds getAdvancedMoldFromString(String mold) {
        switch (mold) {
            case "singularity":
                return AdvancedMolds.SINGULARITY;
            case "crystallized":
                return AdvancedMolds.CRYSTALLIZED;
            case "ingot":
                return AdvancedMolds.INGOT;
            case "mold":
                return AdvancedMolds.MOLD;
            case "rod":
                return AdvancedMolds.ROD;
            case "crystalline_empty":
                return AdvancedMolds.CRYSTALLINE_EMPTY;
            case "crystalline_gem":
                return AdvancedMolds.CRYSTALLINE_GEM;
            default:
                return AdvancedMolds.EMPTY;
        }
    }

    public static Molds getNextMold(Molds mold) {
        switch (mold) {
            case EMPTY:
                return Molds.SINGULARITY;
            case SINGULARITY:
                return Molds.CRYSTALLIZED;
            case CRYSTALLIZED:
                return Molds.INGOT;
            case INGOT:
                return Molds.MOLD;
            case MOLD:
                return Molds.ROD;
            case ROD:
                return Molds.EMPTY;
        }
        return Molds.EMPTY;
    }

    public static AdvancedMolds getNextAdvancedMold(AdvancedMolds mold) {
        switch (mold) {
            case EMPTY:
                return AdvancedMolds.SINGULARITY;
            case SINGULARITY:
                return AdvancedMolds.CRYSTALLIZED;
            case CRYSTALLIZED:
                return AdvancedMolds.INGOT;
            case INGOT:
                return AdvancedMolds.MOLD;
            case MOLD:
                return AdvancedMolds.ROD;
            case ROD:
                return AdvancedMolds.CRYSTALLINE_EMPTY;
            case CRYSTALLINE_EMPTY:
                return AdvancedMolds.CRYSTALLINE_GEM;
            case CRYSTALLINE_GEM:
                return AdvancedMolds.EMPTY;
        }
        return AdvancedMolds.EMPTY;
    }
}
