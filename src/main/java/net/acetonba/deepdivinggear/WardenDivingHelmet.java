package net.acetonba.deepdivinggear;

import com.simibubi.create.content.equipment.armor.DivingHelmetItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WardenDivingHelmet extends DivingHelmetItem {

    public WardenDivingHelmet(Holder<ArmorMaterial> material, Properties properties, ResourceLocation textureLoc) {
        super(material, properties, textureLoc);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof ServerPlayer player) {
            if(stack.getEquipmentSlot() == EquipmentSlot.HEAD) {
                if(player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
                if(player.hasEffect(MobEffects.DARKNESS)) player.removeEffect(MobEffects.DARKNESS);
            }
        }
    }
}
