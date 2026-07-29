package net.acetonba.deepdivinggear;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;

public class DDGPartialModels {
    public static final PartialModel
    WARDEN_BACKTANK_SHAFT = PartialModel.of(DeepDivingGear.asResource("block/warden_backtank/block_shaft_input")),
    WARDEN_BACKTANK_COGS =  PartialModel.of(DeepDivingGear.asResource("block/warden_backtank/block_cogs"));

    public static void init() {
        // init static fields
    }
}
