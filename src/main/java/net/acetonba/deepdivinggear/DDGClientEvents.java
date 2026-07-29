package net.acetonba.deepdivinggear;


import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(Dist.CLIENT)
public class DDGClientEvents {
    @SubscribeEvent
    public static void onTickPre(ClientTickEvent.Pre event) {
        onTick(true);
    }

    @SubscribeEvent
    public static void onTickPost(ClientTickEvent.Post event) {
        onTick(false);
    }

    public static void onTick(boolean isPreEvent) {
        if (!isGameActive())
            return;

        WardenBacktankFirstPersonRenderer.clientTick();
    }

    protected static boolean isGameActive() {
        return !(Minecraft.getInstance().level == null || Minecraft.getInstance().player == null);
    }
}
