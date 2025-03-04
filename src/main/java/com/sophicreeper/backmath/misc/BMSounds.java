package com.sophicreeper.backmath.misc;

import com.sophicreeper.backmath.BackMath;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class BMSounds {
    // Music Discs
    public static SoundEvent RECORD_NATHAN_EVANS_WELLERMAN;
    public static SoundEvent RECORD_SIA_SNOWMAN;
    public static SoundEvent RECORD_ERICWHO1_DADADADA_DA;
    public static SoundEvent RECORD_DUNCAN_LAURENCE_ARCADE;
    public static SoundEvent RECORD_HATSUNE_MIKU_O_ZONIBUS_VAI_DERRAPAR;
    public static SoundEvent RECORD_RIHANNA_UMBRELLA;
    public static SoundEvent RECORD_ELYOTTO_SUGAR_CRASH;
    public static SoundEvent RECORD_HATSUNE_MIKU_IEVAN_POLKKA;
    public static SoundEvent RECORD_RICK_ASTLEY_NEVER_GONNA_GIVE_YOU_UP;
    public static SoundEvent RECORD_MANESKIN_BEGGIN;
    public static SoundEvent RECORD_JUSTIN_BIEBER_STAY;
    public static SoundEvent RECORD_SOPHICREEPER_THE_FLYING_ARM;
    public static SoundEvent RECORD_SOPHICREEPER_SOPHIES_DRAMATIC_ENTRANCE_1;
    public static SoundEvent RECORD_SOPHICREEPER_SOPHIES_DRAMATIC_ENTRANCE_2;
    public static SoundEvent RECORD_SOPHICREEPER_SOPHIES_DRAMATIC_ENTRANCE_3;

    // Music
    public static SoundEvent MUSIC_OVERWORLD_BACK_FIELDS;
    public static SoundEvent MUSIC_OVERWORLD_ANGELIC_WOODS;
    public static SoundEvent MUSIC_ALJAN;

    // Blocks
    public static SoundEvent BLOCK_CRYSTALLIZER_CRAFT;
    public static SoundEvent BLOCK_CRYSTALLIZER_FAIL_CRAFT;
    public static SoundEvent BLOCK_CRYSTALLIZER_CHANGE_MOLD;
    public static SoundEvent BLOCK_ALJAN_PORTAL_STAND_FILL;

    // Items
    public static SoundEvent ITEM_CHOCOGLUE_SHOOT;
    public static SoundEvent ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_AIR;
    public static SoundEvent ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_GROUND;
    public static SoundEvent ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_GROUND_HEAVY;
    public static SoundEvent ITEM_MID_TERM_ACTIVATE_ENDER_EYE;
    public static SoundEvent ITEM_MID_TERM_ACTIVATE_BEACON;
    public static SoundEvent ITEM_MID_TERM_DEACTIVATE_ENDER_EYE;
    public static SoundEvent ITEM_MID_TERM_DEACTIVATE_BEACON;

    // Entities
    public static SoundEvent ENTITY_TERMIAN_SWIM;
    public static SoundEvent ENTITY_TERMIAN_SPLASH;
    public static SoundEvent ENTITY_TERMIAN_SPLASH_HIGH_SPEED;

    public static SoundEvent ENTITY_SOPHIE_HURT_ON_FIRE;
    public static SoundEvent ENTITY_SOPHIE_HURT_DROWN;
    public static SoundEvent ENTITY_SOPHIE_HURT_BERRY_BUSH;
    public static SoundEvent ENTITY_SOPHIE_HURT;
    public static SoundEvent ENTITY_SOPHIE_DEATH;
    public static SoundEvent ENTITY_SOPHIE_SHOOT;
    public static SoundEvent ENTITY_SOPHIE_CELEBRATE;
    public static SoundEvent ENTITY_QUEEN_LUCY_CAST_SPELL;
    public static SoundEvent ENTITY_QUEEN_LUCY_PREPARE_SUMMON;
    public static SoundEvent ENTITY_QUEEN_LUCY_PREPARE_HEAL;

    public static SoundEvent ENTITY_LUCIA_HURT_ON_FIRE;
    public static SoundEvent ENTITY_LUCIA_HURT_DROWN;
    public static SoundEvent ENTITY_LUCIA_HURT_BERRY_BUSH;
    public static SoundEvent ENTITY_LUCIA_HURT;
    public static SoundEvent ENTITY_LUCIA_DEATH;
    public static SoundEvent ENTITY_LUCIA_CELEBRATE;

    public static SoundEvent ENTITY_ALCALYTE_HURT_ON_FIRE;
    public static SoundEvent ENTITY_ALCALYTE_HURT_DROWN;
    public static SoundEvent ENTITY_ALCALYTE_HURT_BERRY_BUSH;
    public static SoundEvent ENTITY_ALCALYTE_HURT;
    public static SoundEvent ENTITY_ALCALYTE_DEATH;
    public static SoundEvent ENTITY_ALCALYTE_BURP;

    public static SoundEvent ENTITY_MALAIKA_HURT_ON_FIRE;
    public static SoundEvent ENTITY_MALAIKA_HURT_DROWN;
    public static SoundEvent ENTITY_MALAIKA_HURT_BERRY_BUSH;
    public static SoundEvent ENTITY_MALAIKA_HURT;
    public static SoundEvent ENTITY_MALAIKA_DEATH;

    public static SoundEvent ENTITY_AMARACAMELER_JUMP;
    public static SoundEvent ENTITY_AMARACAMELER_JUMP_SMALL;
    public static SoundEvent ENTITY_AMARACAMELER_SQUISH;
    public static SoundEvent ENTITY_AMARACAMELER_SQUISH_SMALL;
    public static SoundEvent ENTITY_AMARACAMELER_HURT;
    public static SoundEvent ENTITY_AMARACAMELER_HURT_SMALL;
    public static SoundEvent ENTITY_AMARACAMELER_DEATH;
    public static SoundEvent ENTITY_AMARACAMELER_DEATH_SMALL;
    public static SoundEvent ENTITY_AMARACAMELER_ATTACK;

    public static SoundEvent ENTITY_ZOMBIE_FABRICIO_CURE;

    public static void registerSounds() {
        // Music Discs
        RECORD_NATHAN_EVANS_WELLERMAN = registerSound("record.nathan_evans.wellerman");
        RECORD_SIA_SNOWMAN = registerSound("record.sia.snowman");
        RECORD_ERICWHO1_DADADADA_DA = registerSound("record.ericwho.dadadada_da");
        RECORD_DUNCAN_LAURENCE_ARCADE = registerSound("record.duncan_laurence.arcade");
        RECORD_HATSUNE_MIKU_O_ZONIBUS_VAI_DERRAPAR = registerSound("record.hatsune_miku.zonibus");
        RECORD_RIHANNA_UMBRELLA = registerSound("record.rihanna.umbrella");
        RECORD_ELYOTTO_SUGAR_CRASH = registerSound("record.elyotto.sugar_crash");
        RECORD_HATSUNE_MIKU_IEVAN_POLKKA = registerSound("record.hatsune_miku.levan_polkka");
        RECORD_RICK_ASTLEY_NEVER_GONNA_GIVE_YOU_UP = registerSound("record.rick_astley.never_gonna_give_you_up");
        RECORD_MANESKIN_BEGGIN = registerSound("record.maneskin.beggin");
        RECORD_JUSTIN_BIEBER_STAY = registerSound("record.justin_bieber.stay");
        RECORD_SOPHICREEPER_THE_FLYING_ARM = registerSound("record.sophicreeper.the_flying_arm");
        RECORD_SOPHICREEPER_SOPHIES_DRAMATIC_ENTRANCE_1 = registerSound("record.sophicreeper.sophies_dramatic_entrance.1");
        RECORD_SOPHICREEPER_SOPHIES_DRAMATIC_ENTRANCE_2 = registerSound("record.sophicreeper.sophies_dramatic_entrance.2");
        RECORD_SOPHICREEPER_SOPHIES_DRAMATIC_ENTRANCE_3 = registerSound("record.sophicreeper.sophies_dramatic_entrance.3");

        // Music
        MUSIC_OVERWORLD_BACK_FIELDS = registerSound("music.overworld.back_fields");
        MUSIC_OVERWORLD_ANGELIC_WOODS = registerSound("music.overworld.angelic_woods");
        MUSIC_ALJAN = registerSound("music.aljan");

        // Blocks
        BLOCK_CRYSTALLIZER_CRAFT = registerSound("block.crystallizer.craft");
        BLOCK_CRYSTALLIZER_FAIL_CRAFT = registerSound("block.crystallizer.failed_craft");
        BLOCK_CRYSTALLIZER_CHANGE_MOLD = registerSound("block.crystallizer.change_mold");
        BLOCK_ALJAN_PORTAL_STAND_FILL = registerSound("block.aljan_portal_stand.fill");

        // Items
        ITEM_CHOCOGLUE_SHOOT = registerSound("item.chocoglue.shoot");
        ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_GROUND_HEAVY = registerSound("item.queen_lucy_summoner_staff.smash_ground_heavy");
        ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_GROUND = registerSound("item.queen_lucy_summoner_staff.smash_ground");
        ITEM_QUEEN_LUCY_SUMMONER_STAFF_SMASH_AIR = registerSound("item.queen_lucy_summoner_staff.smash_air");
        ITEM_MID_TERM_ACTIVATE_ENDER_EYE = registerSound("item.mid_term.activate.ender_eye");
        ITEM_MID_TERM_ACTIVATE_BEACON = registerSound("item.mid_term.activate.beacon");
        ITEM_MID_TERM_DEACTIVATE_ENDER_EYE = registerSound("item.mid_term.deactivate.ender_eye");
        ITEM_MID_TERM_DEACTIVATE_BEACON = registerSound("item.mid_term.deactivate.beacon");

        // Entities
        ENTITY_TERMIAN_SWIM = registerSound("entity.termian.swim");
        ENTITY_TERMIAN_SPLASH = registerSound("entity.termian.splash");
        ENTITY_TERMIAN_SPLASH_HIGH_SPEED = registerSound("entity.termian.splash.high_speed");

        ENTITY_SOPHIE_HURT_ON_FIRE = registerSound("entity.sophie.hurt.on_fire");
        ENTITY_SOPHIE_HURT_DROWN = registerSound("entity.sophie.hurt.drown");
        ENTITY_SOPHIE_HURT_BERRY_BUSH = registerSound("entity.sophie.hurt.berry_bush");
        ENTITY_SOPHIE_HURT = registerSound("entity.sophie.hurt");
        ENTITY_SOPHIE_DEATH = registerSound("entity.sophie.death");
        ENTITY_SOPHIE_SHOOT = registerSound("entity.sophie.shoot");
        ENTITY_SOPHIE_CELEBRATE = registerSound("entity.sophie.celebrate");
        ENTITY_QUEEN_LUCY_CAST_SPELL = registerSound("entity.queen_lucy.cast_spell");
        ENTITY_QUEEN_LUCY_PREPARE_HEAL = registerSound("entity.queen_lucy.prepare_heal");
        ENTITY_QUEEN_LUCY_PREPARE_SUMMON = registerSound("entity.queen_lucy.prepare_summon");

        ENTITY_LUCIA_HURT_ON_FIRE = registerSound("entity.lucia.hurt.on_fire");
        ENTITY_LUCIA_HURT_DROWN = registerSound("entity.lucia.hurt.drown");
        ENTITY_LUCIA_HURT_BERRY_BUSH = registerSound("entity.lucia.hurt.berry_bush");
        ENTITY_LUCIA_HURT = registerSound("entity.lucia.hurt");
        ENTITY_LUCIA_DEATH = registerSound("entity.lucia.death");
        ENTITY_LUCIA_CELEBRATE = registerSound("entity.lucia.celebrate");

        ENTITY_ALCALYTE_HURT_ON_FIRE = registerSound("entity.alcalyte.hurt.on_fire");
        ENTITY_ALCALYTE_HURT_DROWN = registerSound("entity.alcalyte.hurt.drown");
        ENTITY_ALCALYTE_HURT_BERRY_BUSH = registerSound("entity.alcalyte.hurt.berry_bush");
        ENTITY_ALCALYTE_HURT = registerSound("entity.alcalyte.hurt");
        ENTITY_ALCALYTE_DEATH = registerSound("entity.alcalyte.death");
        ENTITY_ALCALYTE_BURP = registerSound("entity.alcalyte.burp");

        ENTITY_MALAIKA_HURT_ON_FIRE = registerSound("entity.malaika.hurt.on_fire");
        ENTITY_MALAIKA_HURT_DROWN = registerSound("entity.malaika.hurt.drown");
        ENTITY_MALAIKA_HURT_BERRY_BUSH = registerSound("entity.malaika.hurt.berry_bush");
        ENTITY_MALAIKA_HURT = registerSound("entity.malaika.hurt");
        ENTITY_MALAIKA_DEATH = registerSound("entity.malaika.death");

        ENTITY_AMARACAMELER_JUMP = registerSound("entity.amaracameler.jump");
        ENTITY_AMARACAMELER_JUMP_SMALL = registerSound("entity.amaracameler.jump_small");
        ENTITY_AMARACAMELER_SQUISH = registerSound("entity.amaracameler.squish");
        ENTITY_AMARACAMELER_SQUISH_SMALL = registerSound("entity.amaracameler.squish_small");
        ENTITY_AMARACAMELER_HURT = registerSound("entity.amaracameler.hurt");
        ENTITY_AMARACAMELER_HURT_SMALL = registerSound("entity.amaracameler.hurt_small");
        ENTITY_AMARACAMELER_DEATH = registerSound("entity.amaracameler.death");
        ENTITY_AMARACAMELER_DEATH_SMALL = registerSound("entity.amaracameler.death_small");
        ENTITY_AMARACAMELER_ATTACK = registerSound("entity.amaracameler.attack");

        ENTITY_ZOMBIE_FABRICIO_CURE = registerSound("entity.zombie_fabricio.cure");
    }

    private static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(BackMath.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
