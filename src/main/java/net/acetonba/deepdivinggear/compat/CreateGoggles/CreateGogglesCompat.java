package net.acetonba.deepdivinggear.compat.CreateGoggles;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.acetonba.deepdivinggear.DeepDivingGear;
import net.acetonba.deepdivinggear.WardenDivingHelmet;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

public class CreateGogglesCompat {
    public static final ResourceLocation ID =
            ResourceLocation.fromNamespaceAndPath(DeepDivingGear.MODID, "copper_helmet_goggled");

    public static Supplier<WardenDivingHelmet> GOGGLE_WARDEN_DIVING_HELMET = null;

    public static void init(IEventBus modEventBus) {
        CreateGogglesItems.ITEMS.register(modEventBus);
        GOGGLE_WARDEN_DIVING_HELMET = CreateGogglesItems.GOGGLE_WARDEN_DIVING_HELMET;
        modEventBus.addListener(CreateGogglesCompat::addToCreateTab);
        modEventBus.addListener(CreateGogglesCompat::commonSetup);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TooltipModifier.REGISTRY.register(
                    CreateGogglesItems.GOGGLE_WARDEN_DIVING_HELMET.get(),
                    new ItemDescription.Modifier(
                            CreateGogglesItems.GOGGLE_WARDEN_DIVING_HELMET.get(),
                            FontHelper.Palette.STANDARD_CREATE
                    )
            );
        });
    }

    public static void addToCreateTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == AllCreativeModeTabs.BASE_CREATIVE_TAB.value()) {
            event.accept(CreateGogglesItems.GOGGLE_WARDEN_DIVING_HELMET);
        }
    }
}
