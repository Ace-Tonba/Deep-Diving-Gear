package net.acetonba.deepdivinggear.mixins;

import java.util.Set;

import net.acetonba.deepdivinggear.DDGBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

@Mixin(value = BlockEntityBuilder.class, remap = false)
public abstract class BlockEntityBuilderMixin<T extends BlockEntity, P> {

    @Shadow @Final private Set<NonNullSupplier<? extends Block>> validBlocks;
    @Unique private String name;

    @Inject(method = "register", at = @At("HEAD"))
    private void ddg$injectWardenBacktank(CallbackInfoReturnable<BlockEntityEntry<T>> cir) {
        name = ((AbstractBuilderAccessor) this).ddg$getName();
        if ("backtank".equals(this.name)) {
            this.validBlocks.add(DDGBlocks.WARDEN_BACKTANK::get);
        }
    }
}