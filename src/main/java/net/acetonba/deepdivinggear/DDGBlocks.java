package net.acetonba.deepdivinggear;


import com.simibubi.create.content.equipment.armor.BacktankBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDGBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DeepDivingGear.MODID);

    public static final DeferredBlock<BacktankBlock> WARDEN_BACKTANK = BLOCKS.register(
            "warden_backtank", () -> new BacktankBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
            ));
}
