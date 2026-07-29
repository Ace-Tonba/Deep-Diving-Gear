package net.acetonba.deepdivinggear.mixins;

import com.simibubi.create.content.equipment.armor.BacktankRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.acetonba.deepdivinggear.DDGBlocks;
import net.acetonba.deepdivinggear.DDGPartialModels;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BacktankRenderer.class, remap = false)
public abstract class BacktankRendererMixin {

    @Inject(method = "getCogsModel", at = @At("HEAD"), cancellable = true, remap = false)
    private static void deepdivinggear$getCogsModel(BlockState state, CallbackInfoReturnable<PartialModel> cir) {
        if (state.is(DDGBlocks.WARDEN_BACKTANK.get())) {
            cir.setReturnValue(DDGPartialModels.WARDEN_BACKTANK_COGS);
        }
    }

    @Inject(method = "getShaftModel", at = @At("HEAD"), cancellable = true, remap = false)
    private static void deepdivinggear$getShaftModel(BlockState state, CallbackInfoReturnable<PartialModel> cir) {
        if (state.is(DDGBlocks.WARDEN_BACKTANK.get())) {
            cir.setReturnValue(DDGPartialModels.WARDEN_BACKTANK_SHAFT);
        }
    }
}