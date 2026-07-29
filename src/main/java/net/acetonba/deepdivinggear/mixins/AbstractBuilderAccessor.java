package net.acetonba.deepdivinggear.mixins;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractBuilder.class)
public interface AbstractBuilderAccessor {
    @Accessor("name")
    String ddg$getName();
}