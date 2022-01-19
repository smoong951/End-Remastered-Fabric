package com.endremastered.endrem.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigData {
    @SerializedName("End Gate")
    public Structure END_GATE = new VariableSizeStructure(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            15,
            10,
            5,
            false,
            18
    );

    @SerializedName("End Castle")
    public Structure END_CASTLE = new Structure(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            15,
            10,
            5,
            false
    );

    @SerializedName("Ancient Witch Hut")
    public Structure ANCIENT_WITCH_HUT = new Structure(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            15,
            10,
            5,
            false
    );

    @SerializedName("Whitelisted Dimensions")
    public List<String> WHITELISTED_DIMENSIONS = List.of("minecraft:overworld");

    @SerializedName("Difficulty of Monsters Inside Structures [peaceful, easy, normal, hard or hardcore]")
    public String MONSTER_DIFFICULTY = "normal";

    @SerializedName("End Remastered Eyes")
    public EREye ER_EYES = new EREye(
            0,
            List.of("endrem:end_gate")
    );

    @SerializedName("Vanilla Eyes Can Be Used")
    public boolean ENDER_EYES_ENABLED = false;

    @SerializedName("Vanilla Strongholds Are Enabled")
    public boolean STRONGHOLDS_ENABLED = false;

    @SerializedName("End Remastered Map")
    public ERMap ER_MAP = new ERMap(
            List.of("endrem:end_castle"),
            30,
            40,
            12
    );

    @SerializedName("End Crystal Gear")
    public EndCrystalGear END_CRYSTAL_GEAR = new EndCrystalGear(
            new EndCrystalGear.Armor(
                    33,
                    1,
                    2,
                    0.1f,
                    true,
                    20
            ),

            new EndCrystalGear.Tools(
                    1325,
                    10,
                    3
            )
    );

    public static class EndCrystalGear {

        @SerializedName("End Crystal Armor")
        Armor ARMOR;

        @SerializedName("End Crystal Tools")
        Tools TOOLS;

        private EndCrystalGear(Armor armorIn, Tools toolsIn) {
            ARMOR = armorIn;
            TOOLS = toolsIn;
        }

        public static class Armor {
            @SerializedName("Durability Factor")
            public float durabilityFactor;

            @SerializedName("Defense Factor")
            public float defenseFactor;

            @SerializedName("Thoughness")
            public float thoughness;

            @SerializedName("Knockback Resistance")
            public float knockbackResistance;

            @SerializedName("Neutralizes Piglins")
            public boolean neutralizesPiglins;

            @SerializedName("Regen Duration (Ticks)")
            public int regenDuration;

            private Armor(float durabilityFactorIn, float defenseFactorIn, float thoughnessIn,
                          float knockbackResistanceIn, boolean neutralizesPiglinsIn, int regenDurationIn) {
                this.durabilityFactor = durabilityFactorIn;
                this.defenseFactor = defenseFactorIn;
                this.thoughness = thoughnessIn;
                this.knockbackResistance = knockbackResistanceIn;
                this.neutralizesPiglins = neutralizesPiglinsIn;
                this.regenDuration = regenDurationIn;
            }
        }

        public static class Tools {
            @SerializedName("Durability")
            public int durability;

            @SerializedName("Speed")
            public float speed;

            @SerializedName("Attack Damage Bonus")
            public float damageBonus;

            private Tools(int durabilityIn, float speedIn, float damageBonusIn) {
                this.durability = durabilityIn;
                this.speed = speedIn;
                this.damageBonus = damageBonusIn;
            }
        }
    }

    public static class ERMap {
        @SerializedName("Located Structures")
        public List<String> structureList;

        @SerializedName("Minimum Price in Emeralds")
        public int minPrice;

        @SerializedName("Maximum Price in Emeralds")
        public int maxPrice;

        @SerializedName("XP Received on Purchase")
        public int xpGiven;

        private ERMap(List<String> structureListIn, int minPriceIn, int maxPriceIn, int xpGivenIn) {
            this.structureList = structureListIn;
            this.minPrice = minPriceIn;
            this.maxPrice = maxPriceIn;
            this.xpGiven = xpGivenIn;
        }
    }

    public static class EREye {
        @SerializedName("Break Probability (decimal form)")
        public float breakProbability;

        @SerializedName("Located Structures")
        public List<String> structureList;

        private EREye(float breakProbabilityIn, List<String> structureListIn) {
            this.breakProbability = breakProbabilityIn;
            this.structureList = structureListIn;
        }
    }

    public static class Structure {
        @SerializedName("Whitelisted Biome Categories")
        public List<String> whitelistedBiomeCategories;

        @SerializedName("Blacklisted Biomes")
        public List<String> blacklistedBiomes;

        @SerializedName("Average Distance Between Structures")
        public int averageDistance;

        @SerializedName("Minimum Spawn Distance")
        public int spawnDistance;

        @SerializedName("Generation Height (Above Ground)")
        public int height;

        @SerializedName("Terraforming Enabled")
        public boolean terraforming;

        private Structure(List<String> whitelistedBiomeCategoriesIn, List<String> blacklistedBiomesIn,
                          int averageDistanceIn, int spawnDistanceIn, int heightIn, boolean terraformingIn) {
            this.whitelistedBiomeCategories = whitelistedBiomeCategoriesIn;
            this.blacklistedBiomes = blacklistedBiomesIn;
            this.averageDistance = averageDistanceIn;
            this.spawnDistance = spawnDistanceIn;
            this.height = heightIn;
            this.terraforming = terraformingIn;
        }
    }

    public static class VariableSizeStructure extends Structure {
        public int size;

        private VariableSizeStructure(List<String> whitelistedBiomeCategoriesIn, List<String> blacklistedBiomesIn,
                                      int averageDistanceIn, int spawnDistanceIn, int heightIn, boolean terraformingIn,
                                      int sizeIn) {
            super(whitelistedBiomeCategoriesIn, blacklistedBiomesIn, averageDistanceIn, spawnDistanceIn, heightIn,
                    terraformingIn);
            this.size = sizeIn;
        }
    }
}