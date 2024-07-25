package org.chubby.morearrows.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;
import org.chubby.morearrows.init.EntityInit;
import org.chubby.morearrows.init.ItemInit;
import org.chubby.morearrows.items.enums.ArrowType;

public class ArrowEntity extends AbstractArrow {
    private ArrowType arrowType;

    public ArrowEntity(EntityType<? extends ArrowEntity> type, Level level) {
        super(type, level);
    }

    public ArrowEntity(EntityType<? extends ArrowEntity> type, Level level, LivingEntity shooter, ArrowType arrowType) {
        super(type, shooter, level);
        this.arrowType = arrowType;
    }

    public ArrowEntity(PlayMessages.SpawnEntity spawnEntity, Level worldIn) {
        this(EntityInit.CUS_ARROW.get(), worldIn);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Level level = this.level();
        if(this.arrowType == ArrowType.EXPLOSION)
        {
            double x =pResult.getEntity().getX();
            double y =pResult.getEntity().getY();
            double z =pResult.getEntity().getZ();
            level.explode(pResult.getEntity(),x,y,z,arrowType.getDamage(), Level.ExplosionInteraction.MOB);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Level level = this.level();
        if(this.arrowType == ArrowType.EXPLOSION)
        {
            double x =pResult.getBlockPos().getX();
            double y =pResult.getBlockPos().getY();
            double z =pResult.getBlockPos().getZ();
            level.explode(null,x,y,z,arrowType.getDamage(), Level.ExplosionInteraction.BLOCK);
        }
        else if(this.arrowType == ArrowType.ENDER_PEARL)
        {
            //Player player = pResult.get
        }
    }


    public ArrowType getArrowType()
    {
        return arrowType;
    }

    @Override
    protected ItemStack getPickupItem() {
        Item arrowItem = ItemInit.ITEM_MAP.get(arrowType.getName()).get();
        return new ItemStack(arrowItem);
    }
}
