package net.acetonba.deepdivinggear;

import com.simibubi.create.CreateClient;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBufferCache;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = "deepdivinggear", dist = Dist.CLIENT)
public class DDGClient {

    public DDGClient(IEventBus modEventBus) {
        onCtorClient(modEventBus);
    }

    public static void clientInit(final FMLClientSetupEvent event) {
        SuperByteBufferCache.getInstance().registerCompartment(CachedBuffers.PARTIAL);
        DDGPartialModels.init();
    }

    public static void onCtorClient(IEventBus modEventBus) {
        modEventBus.addListener(DDGClient::clientInit);
    }
}
