package net.acetonba.deepdivinggear;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllDataComponents;
import com.simibubi.create.content.equipment.armor.BacktankUtil;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;


@EventBusSubscriber(modid = DeepDivingGear.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DDGCreativeTab {
    @SubscribeEvent
    public static void addToCreateTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == AllCreativeModeTabs.BASE_CREATIVE_TAB.value()) {
            event.accept(DDGItems.WARDEN_DIVING_HELMET);

            ItemStack backtank = new ItemStack(DDGItems.WARDEN_BACKTANK.get());
            backtank.set(AllDataComponents.BACKTANK_AIR, BacktankUtil.maxAirWithoutEnchants());
            event.accept(backtank);

            event.accept(DDGItems.WARDEN_DIVING_BOOTS);
        }
    }
}