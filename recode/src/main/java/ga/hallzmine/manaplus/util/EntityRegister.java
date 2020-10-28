package ga.hallzmine.manaplus.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import ga.hallzmine.manaplus.ManaPlus;
import ga.hallzmine.manaplus.entities.ProtectorEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ManaPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegister {
    @SubscribeEvent
    public static void registerProtector(RegistryEvent.Register<EntityType<?>> event) {
        Preconditions.checkNotNull(RegistryHandler.PROTECTOR.get().getRegistryName(), "registryName");
        event.getRegistry().register(RegistryHandler.PROTECTOR.get());
        EntitySpawnPlacementRegistry.register(RegistryHandler.PROTECTOR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ProtectorEntity::canSpawnOn);
    }

}
