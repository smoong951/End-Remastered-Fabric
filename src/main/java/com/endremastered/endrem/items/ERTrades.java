package com.endremastered.endrem.items;

import com.endremastered.endrem.registry.ERItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class ERTrades {

    private static class EREyeTrade implements TradeOffers.Factory {
        int maxPrice = 50;
        int minPrice = 30;

        @Override
        public TradeOffer create(@NotNull Entity entity, Random random){
            int priceEmeralds = random.nextInt(maxPrice - minPrice) + minPrice;
            if (!entity.world.isClient) {
                return new TradeOffer(new ItemStack(Items.EMERALD, priceEmeralds), new ItemStack(Items.COMPASS), new ItemStack(ERItems.EVIL_EYE), priceEmeralds, 12, 10, 0.2F);
            }
            return null;
        }
    }

    public static void registerVillagerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
            factories.add(new EREyeTrade());
        });

        TradeOfferHelper.registerWanderingTraderOffers(0,factories -> {
            factories.add(new EREyeTrade());
        });
    }
}
