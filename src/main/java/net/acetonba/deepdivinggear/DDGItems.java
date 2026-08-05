package net.acetonba.deepdivinggear;

import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.simibubi.create.content.equipment.armor.BacktankItem;
import com.simibubi.create.content.equipment.armor.DivingBootsItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeepDivingGear.MODID);



    public static final DeferredItem<WardenDivingHelmet> WARDEN_DIVING_HELMET = ITEMS.register(
            "warden_diving_helmet", () -> new WardenDivingHelmet(
                    DDArmorMaterials.WARDEN,
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .fireResistant()
                            .durability(ArmorItem.Type.HELMET.getDurability(40)),
                    DeepDivingGear.asResource("warden_diving")
                    ));

    public static final DeferredItem<BacktankItem.BacktankBlockItem> WARDEN_BACKTANK_PLACEABLE = ITEMS.register(
            "warden_backtank_placeable", () -> new BacktankItem.BacktankBlockItem(
                    DDGBlocks.WARDEN_BACKTANK.get(),
                    DDGItems.WARDEN_BACKTANK::get,
                    new Item.Properties()
            ));


    public static final DeferredItem<BacktankItem> WARDEN_BACKTANK = ITEMS.register(
            "warden_backtank", () -> new BacktankItem.Layered(
                    DDArmorMaterials.WARDEN,
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .fireResistant(),
                    DeepDivingGear.asResource("warden_diving"),
                    WARDEN_BACKTANK_PLACEABLE
            ));

    public static final DeferredItem<DivingBootsItem> WARDEN_DIVING_BOOTS = ITEMS.register(
            "warden_diving_boots", () -> new DivingBootsItem(
                    DDArmorMaterials.WARDEN,
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .fireResistant()
                            .durability(ArmorItem.Type.BOOTS.getDurability(40)),
                    DeepDivingGear.asResource("warden_diving")
            ));
}
