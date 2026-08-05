package net.acetonba.deepdivinggear;

import com.simibubi.create.api.stress.BlockStressValues;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.acetonba.deepdivinggear.compat.CreateGoggles.CreateGogglesCompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.createmod.catnip.lang.FontHelper.Palette;

import java.util.function.Supplier;


@Mod(net.acetonba.deepdivinggear.DeepDivingGear.MODID)
@EventBusSubscriber(modid = DeepDivingGear.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DeepDivingGear {
    public static final String MODID = "deepdivinggear";


    public DeepDivingGear(IEventBus modEventBus, ModContainer modContainer) {
        DDGItems.ITEMS.register(modEventBus);
        DDGBlocks.BLOCKS.register(modEventBus);
        if (ModList.get().isLoaded("creategoggles")) {
            CreateGogglesCompat.init(modEventBus);
        }
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BlockStressValues.IMPACTS.register(DDGBlocks.WARDEN_BACKTANK.get(), () -> 4.0);

            TooltipModifier.REGISTRY.register(
                    DDGItems.WARDEN_DIVING_HELMET.get(),
                    new ItemDescription.Modifier(
                            DDGItems.WARDEN_DIVING_HELMET.get(),
                            Palette.STANDARD_CREATE
                    )
            );

            TooltipModifier.REGISTRY.register(
                    DDGItems.WARDEN_BACKTANK.get(),
                    new ItemDescription.Modifier(
                            DDGItems.WARDEN_BACKTANK.get(),
                            Palette.STANDARD_CREATE
                    )
            );

            TooltipModifier.REGISTRY.register(
                    DDGItems.WARDEN_DIVING_BOOTS.get(),
                    new ItemDescription.Modifier(
                            DDGItems.WARDEN_DIVING_BOOTS.get(),
                            Palette.STANDARD_CREATE
                    )
            );
        });
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath("deepdivinggear", path);
    }
}
