package io.github.moulberry.notenoughupdates.overlays;

import com.google.common.collect.Lists;
import io.github.moulberry.notenoughupdates.NotEnoughUpdates;
import io.github.moulberry.notenoughupdates.core.config.Position;
import io.github.moulberry.notenoughupdates.miscfeatures.PetInfoOverlay;

import java.util.ArrayList;
import java.util.List;

public class OverlayManager {

    public static Class<? extends TextOverlay> dontRenderOverlay = null;

    public static MiningOverlay miningOverlay;
    public static FarmingOverlay farmingOverlay;
    public static PetInfoOverlay petInfoOverlay;
    public static CityProjectPinOverlay cityProjectPinOverlay;
    public static TimersOverlay timersOverlay;
    public static final List<TextOverlay> textOverlays = new ArrayList<>();

    static {
        List<String> todoDummy = Lists.newArrayList(
                "\u00a73Cakes: \u00a7eInactive!",
                "\u00a73Cookie Buff: \u00a7eInactive!",
                "\u00a73Godpot: \u00a7eInactive!",
                "\u00a73Puzzler: \u00a7eReady!",
                "\u00a73Fetchur: \u00a7eReady!",
                "\u00a73Commissions: \u00a7eReady!",
                "\u00a73Experiments: \u00a7eReady!",
                "\u00a73Cakes: \u00a7e1d21h",
                "\u00a73Cookie Buff: \u00a7e2d23h",
                "\u00a73Godpot: \u00a7e19h",
                "\u00a73Puzzler: \u00a7e13h",
                "\u00a73Fetchur: \u00a7e3h38m",
                "\u00a73Commissions: \u00a7e3h38m",
                "\u00a73Experiments: \u00a7e3h38m");
        textOverlays.add(timersOverlay = new TimersOverlay(NotEnoughUpdates.INSTANCE.config.miscOverlays.todoPosition, () -> {
            List<String> strings = new ArrayList<>();
            for(int i : NotEnoughUpdates.INSTANCE.config.miscOverlays.todoText) {
                if(i >= 0 && i < todoDummy.size()) strings.add(todoDummy.get(i));
            }
            return strings;
        }, () -> {
            int style = NotEnoughUpdates.INSTANCE.config.miscOverlays.todoStyle;
            if(style >= 0 && style < TextOverlayStyle.values().length) {
                return TextOverlayStyle.values()[style];
            }
            return TextOverlayStyle.BACKGROUND;
        }));

        List<String> miningDummy = Lists.newArrayList("\u00a73Goblin Slayer: \u00a7626.5%\n\u00a73Lucky Raffle: \u00a7c0.0%",
                "\u00a73Mithril Powder: \u00a726,243",
                "\u00a73Forge 1) \u00a79Diamonite\u00a77: \u00a7aReady!",
                "\u00a73Forge 2) \u00a77EMPTY\n\u00a73Forge 3) \u00a77EMPTY\n\u00a73Forge 4) \u00a77EMPTY");
        miningOverlay = new MiningOverlay(NotEnoughUpdates.INSTANCE.config.mining.overlayPosition, () -> {
            List<String> strings = new ArrayList<>();
            for(int i : NotEnoughUpdates.INSTANCE.config.mining.dwarvenText) {
                if(i >= 0 && i < miningDummy.size()) strings.add(miningDummy.get(i));
            }
            return strings;
        }, () -> {
            int style = NotEnoughUpdates.INSTANCE.config.mining.overlayStyle;
            if(style >= 0 && style < TextOverlayStyle.values().length) {
                return TextOverlayStyle.values()[style];
            }
            return TextOverlayStyle.BACKGROUND;
        });

        List<String> farmingDummy = Lists.newArrayList("\u00a7bCounter: \u00a7e37,547,860",
                "\u00a7bCrops/m: \u00a7e38.29",
                "\u00a7bFarm: \u00a7e12\u00a77 [\u00a7e|||||||||||||||||\u00a78||||||||\u00a77] \u00a7e67%",
                "\u00a7bCurrent XP: \u00a7e6,734",
                "\u00a7bRemaining XP: \u00a7e3,265",
                "\u00a7bXP/h: \u00a7e238,129",
                "\u00a7bYaw: \u00a7e68.25\u00a7l\u1D52");
        farmingOverlay = new FarmingOverlay(NotEnoughUpdates.INSTANCE.config.skillOverlays.farmingPosition, () -> {
            List<String> strings = new ArrayList<>();
            for(int i : NotEnoughUpdates.INSTANCE.config.skillOverlays.farmingText) {
                if(i >= 0 && i < farmingDummy.size()) strings.add(farmingDummy.get(i));
            }
            return strings;
        }, () -> {
            int style = NotEnoughUpdates.INSTANCE.config.skillOverlays.farmingStyle;
            if(style >= 0 && style < TextOverlayStyle.values().length) {
                return TextOverlayStyle.values()[style];
            }
            return TextOverlayStyle.BACKGROUND;
        });

        List<String> petInfoDummy = Lists.newArrayList("\u00a7a[Lvl 37] \u00a7fRock",
                "\u00a7b2,312.9/2,700\u00a7e (85.7%)",
                "\u00a7b2.3k/2.7k\u00a7e (85.7%)",
                "\u00a7bXP/h: \u00a7e27,209",
                "\u00a7bTotal XP: \u00a7e30,597.9",
                "\u00a7bHeld Item: \u00a7fMining Exp Boost",
                "\u00a7bUntil L38: \u00a7e5m13s",
                "\u00a7bUntil L100: \u00a7e2d13h");
        petInfoOverlay = new PetInfoOverlay(NotEnoughUpdates.INSTANCE.config.petOverlay.petInfoPosition, () -> {
            List<String> strings = new ArrayList<>();
            for(int i : NotEnoughUpdates.INSTANCE.config.petOverlay.petOverlayText) {
                if(i >= 0 && i < petInfoDummy.size()) strings.add(petInfoDummy.get(i));
            }
            return strings;
        }, () -> {
            int style = NotEnoughUpdates.INSTANCE.config.petOverlay.petInfoOverlayStyle;
            if(style >= 0 && style < TextOverlayStyle.values().length) {
                return TextOverlayStyle.values()[style];
            }
            return TextOverlayStyle.BACKGROUND;
        });

        textOverlays.add(miningOverlay);
        textOverlays.add(farmingOverlay);
        textOverlays.add(petInfoOverlay);


        cityProjectPinOverlay = new CityProjectPinOverlay(NotEnoughUpdates.INSTANCE.config.miscOverlays.cityProjectPinPosition, () -> {
            List<String> strings = new ArrayList<>();
            strings.add("Project - Bartender's Brewery");
            strings.add("  \u00a7aBuilding & Machinery");
            strings.add("    \u00a7aEnchanted Birch Wood \u00a722\u00a7f/\u00a722");
            strings.add("    \u00a7aEnchanted Iron \u00a7c0\u00a7f/\u00a721");
            strings.add("  \u00a7aSugary Drinks");
            strings.add("    \u00a7aEnchanted Sugar \u00a7c16\u00a7f/\u00a7232");
            strings.add("    \u00a7fMagical Water Bucket \u00a7216\u00a7f/\u00a728");
            strings.add("  \u00a7aSlavic Recipes");
            strings.add("    \u00a7aEnchanted Potato \u00a7c60\u00a7f/\u00a7264");
            strings.add("    \u00a7fMagical Water Bucket \u00a7216\u00a7f/\u00a728");
            strings.add("  \u00a7aLabor");
            strings.add("    \u00a7aEnchanted Clownfish \u00a7c2\u00a7f/\u00a724");
            strings.add("    \u00a7aEnchanted Melon \u00a7264\u00a7f/\u00a7264");
            strings.add("    \u00a7b100 Bits");
            return strings;
        }, () -> {
            int style = NotEnoughUpdates.INSTANCE.config.miscOverlays.cityProjectPinStyle;
            if(style >= 0 && style < TextOverlayStyle.values().length) {
                return TextOverlayStyle.values()[style];
            }
            return TextOverlayStyle.BACKGROUND;
        });
        textOverlays.add(cityProjectPinOverlay);

    }

}
