package org.chubby.morearrows.extra;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import org.chubby.morearrows.mixin.WolfVarMixins;

public class ModWolfRenderer extends WolfRenderer
{

    public ModWolfRenderer(EntityRendererProvider.Context p_174452_) {
        super(p_174452_);
    }

    @Override
    public ResourceLocation getTextureLocation(Wolf entity) {
        return ((IWolfVars)entity).getVariant();
    }

}
