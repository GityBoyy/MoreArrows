package org.chubby.morearrows.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.chubby.morearrows.Morearrows;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TabInit
{
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Morearrows.MODID);

    public static final List<Supplier<? extends Item>> ITEM_LIST = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> TAB_ITEMS = TABS.register("items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Morearrows.MODID + ".items"))
            .icon(() -> new ItemStack(ItemStack.EMPTY.getItem()))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((params, output) -> {
                ITEM_LIST.forEach(block -> output.accept(block.get()));
            })
            .build()
    );
}
