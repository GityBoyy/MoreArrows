package org.chubby.morearrows.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.chubby.morearrows.Morearrows;
import org.chubby.morearrows.items.ItemCustomArrow;
import org.chubby.morearrows.items.enums.ArrowType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
@Mod.EventBusSubscriber(modid = Morearrows.MODID)
public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Morearrows.MODID);
    public static final Map<String, RegistryObject<Item>> ITEM_MAP = new HashMap<>();

    static
    {
        for (ArrowType type : ArrowType.values()) {
            RegistryObject<Item> item = registerItem(type.getName() + "_arrow", ()-> new ItemCustomArrow(type));
            ITEM_MAP.put(type.getName(), item);
        }
    }

    public static<I extends Item> RegistryObject<I> registerItem(String name, Supplier<I> regItem)
    {
        return registerItem(name,regItem,true);
    }
    public static<I extends Item> RegistryObject<I> registerItem(String name, Supplier<I> regItem,boolean putInTab)
    {
        RegistryObject<I> registryObject = ITEMS.register(name,regItem);
        if(putInTab)
        {
            TabInit.ITEM_LIST.add(registryObject);
        }
        return registryObject;
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
        Morearrows.LOGGER.info("Registring Items for"+Morearrows.MODID);
    }
}
