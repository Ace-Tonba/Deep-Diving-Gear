package net.acetonba.deepdivinggear.compat.CreateGoggles;

import com.kyanite.deeperdarker.util.DDArmorMaterials;
import net.acetonba.deepdivinggear.DeepDivingGear;
import net.acetonba.deepdivinggear.WardenDivingHelmet;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateGogglesItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeepDivingGear.MODID);

    public static final DeferredItem<WardenDivingHelmet> GOGGLE_WARDEN_DIVING_HELMET = ITEMS.register(
            "goggle_warden_diving_helmet", () -> new WardenDivingHelmet(
                    DDArmorMaterials.WARDEN,
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .fireResistant()
                            .durability(ArmorItem.Type.HELMET.getDurability(40)),
                    DeepDivingGear.asResource("warden_diving")
            ));
}