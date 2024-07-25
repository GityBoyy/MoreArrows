package org.chubby.morearrows;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.chubby.morearrows.init.EntityInit;
import org.chubby.morearrows.init.ItemInit;
import org.chubby.morearrows.init.TabInit;
import org.slf4j.Logger;

@Mod(Morearrows.MODID)
public class Morearrows {

    public static final String MODID = "morearrows";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Morearrows() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);
        TabInit.TABS.register(modEventBus);
        EntityInit.ENTITIES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
