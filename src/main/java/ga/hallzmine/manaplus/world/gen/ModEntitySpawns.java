package ga.hallzmine.manaplus.world.gen;

import ga.hallzmine.manaplus.ManaPlus;
import ga.hallzmine.manaplus.entities.ProtectorEntity;
import ga.hallzmine.manaplus.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
/*
@Mod.EventBusSubscriber(modid = ManaPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
                if (biome.getRegistryName() == RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation("mana-plus:flower_plains_biome")).getLocation()) {
                    biome.getMobSpawnInfo().getSpawners(EntityClassification.CREATURE)
                            .add(new MobSpawnInfo.Spawners(RegistryHandler.PROTECTOR.get(), 10, 3, 5));
                }

            }
        }
    }

*/
