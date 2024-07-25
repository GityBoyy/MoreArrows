package org.chubby.morearrows.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import org.chubby.morearrows.Morearrows;
import org.chubby.morearrows.extra.IWolfVars;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(Wolf.class)
public abstract class WolfVarMixins implements IWolfVars {
    private static final ResourceLocation[] WOLF_VARIANTS = new ResourceLocation[]{
            new ResourceLocation(Morearrows.MODID, "textures/entity/wolf/wolf_variant1.png"),
            new ResourceLocation(Morearrows.MODID, "textures/entity/wolf/wolf_variant2.png")
    };

    private ResourceLocation currentVariant;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        if (this.currentVariant == null) {
            Random rand = new Random();
            this.currentVariant = WOLF_VARIANTS[rand.nextInt(WOLF_VARIANTS.length)];
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
    private void addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
        compound.putString("Variant", this.currentVariant.toString());
    }

    @Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
    private void readAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
        this.currentVariant = new ResourceLocation(compound.getString("Variant"));
    }

    @Override
    public ResourceLocation getVariant() {
        return this.currentVariant;
    }
}
