package org.chubby.morearrows.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.chubby.morearrows.Morearrows;
import org.chubby.morearrows.client.renderer.CusArrowRenderer;
import org.chubby.morearrows.init.EntityInit;

@Mod.EventBusSubscriber(modid = Morearrows.MODID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class CommonModEvents
{
    @SubscribeEvent
    public static void clientSetupEvent(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(EntityInit.CUS_ARROW.get(), CusArrowRenderer::new);
    }
}
