package org.chubby.morearrows.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.chubby.morearrows.entity.ArrowEntity;
import org.chubby.morearrows.init.EntityInit;
import org.chubby.morearrows.items.enums.ArrowType;

public class ItemCustomArrow extends ArrowItem {
    private final ArrowType arrowType;

    public ItemCustomArrow(ArrowType arrowType) {
        super(new Properties());
        this.arrowType = arrowType;
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        return new ArrowEntity(EntityInit.CUS_ARROW.get(), level, shooter, this.arrowType);
    }

    public ArrowType getArrowType() {
        return arrowType;
    }
}
