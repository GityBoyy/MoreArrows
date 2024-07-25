package org.chubby.morearrows.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.chubby.morearrows.Morearrows;
import org.chubby.morearrows.entity.ArrowEntity;

public class EntityInit
{
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Morearrows.MODID);

    public static final RegistryObject<EntityType<ArrowEntity>> CUS_ARROW =
            registerEntity(EntityType.Builder.<ArrowEntity>of(ArrowEntity::new, MobCategory.MISC),
                    "cus_arrow");

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(EntityType.Builder<T> builder, String entityName) {
        return ENTITIES.register(entityName, () -> builder.build(entityName));
    }

    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
        Morearrows.LOGGER.info("Registring Entities for "+Morearrows.MODID);
    }
}
