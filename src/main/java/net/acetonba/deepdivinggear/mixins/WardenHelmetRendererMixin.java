package net.acetonba.deepdivinggear.mixins;
import com.kyanite.deeperdarker.client.render.WardenHelmetRenderer;
import net.acetonba.deepdivinggear.DDGItems;
import net.acetonba.deepdivinggear.compat.CreateGoggles.CreateGogglesCompat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WardenHelmetRenderer.class)
public class WardenHelmetRendererMixin {
    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
            )
    )
    private boolean checkHelmet(ItemStack stack, Item item) {
        return stack.is(item) || stack.is(DDGItems.WARDEN_DIVING_HELMET.get()) || (CreateGogglesCompat.GOGGLE_WARDEN_DIVING_HELMET != null && stack.is(CreateGogglesCompat.GOGGLE_WARDEN_DIVING_HELMET.get()));

    }
}
