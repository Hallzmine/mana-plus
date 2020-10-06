package ga.hallzmine.manaplus.util;

import ga.hallzmine.manaplus.ManaPlus;
import ga.hallzmine.manaplus.blocks.*;
import ga.hallzmine.manaplus.effects.EffectManaSickness;
import ga.hallzmine.manaplus.entities.ProtectorEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.capability.ItemFluidContainer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    //Defines the deferredRegisters of each type of thing
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ManaPlus.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ManaPlus.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ManaPlus.MOD_ID);
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, ManaPlus.MOD_ID);
    //public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ManaPlus.MOD_ID);
    //public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ManaPlus.MOD_ID);

    public static void init() {
        //Registers the deferredregisters
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        //EntitySpawnPlacementRegistry::register(EntityClassification.AMBIENT, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.WORLD_SURFACE, ProtectorEntity.class);
    }

    //Items
    public static final RegistryObject<Item> DESERT_NOVA_SEED = ITEMS.register("desert_nova_seed", () -> new BlockItem(RegistryHandler.DESERT_NOVA_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> TARMA_ROOT_SEED = ITEMS.register("tarma_root_seed", () -> new BlockItem(RegistryHandler.TARMA_ROOT_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> WAKEBLOOM_SEED = ITEMS.register("wakebloom_seed", () -> new BlockItem(RegistryHandler.WAKEBLOOM_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> AUM_SEED = ITEMS.register("aum_seed", () -> new BlockItem(RegistryHandler.AUM_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> CERUBLOSSOM_SEED = ITEMS.register("cerublossom_seed", () -> new BlockItem(RegistryHandler.CERUBLOSSOM_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    //public static final RegistryObject<Item> MANA_BUCKET ITEMS>.register("mana_bucket", () -> new ManaBucket());

    //Blocks
    public static final RegistryObject<Block> DESERT_NOVA_CROP = BLOCKS.register("desert_nova_crop", () -> new DesertNovaCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> TARMA_ROOT_CROP = BLOCKS.register("tarma_root_crop", () -> new TarmaRootCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> WAKEBLOOM_CROP = BLOCKS.register("wakebloom_crop", () -> new WakebloomCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> AUM_CROP = BLOCKS.register("aum_crop", () -> new AumCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> CERUBLOSSOM_CROP = BLOCKS.register("cerublossom_crop", () -> new CerublossomCrop(Block.Properties.from(Blocks.WHEAT)));
    //public static final RegistryObject<Block>
    //public static final RegistryObject<FlowingFluidBlock> MANA_BLOCK = BLOCKS.register("etherium", () -> new FlowingFluidBlock(() -> RegistryHandler.MANA_FLUID.get(), AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().noDrops()));

    //Entity Types
    public static final RegistryObject<EntityType<ProtectorEntity>> PROTECTOR = ENTITY_TYPES.register("protector", () -> EntityType.Builder.create(ProtectorEntity::new, EntityClassification.AMBIENT).size(1.0f, 4.5f).build(new ResourceLocation(ManaPlus.MOD_ID, "protector").toString()));

    //Effects
    public static final RegistryObject<Effect> MANA_SICKNESS = EFFECTS.register("mana_sickness", () -> new EffectManaSickness(EffectType.HARMFUL, 0));
    //Fluids
    //public static final RegistryObject<FlowingFluid> MANA_FLUID = FLUIDS.register("mana_fluid", () -> new ForgeFlowingFluid.Source(RegistryHandler.MANA_FLUID_PROPERTIES));
    //public static final RegistryObject<FlowingFluid> MANA_FLOWING = FLUIDS.register("mana_fluid", () -> new ForgeFlowingFluid.Flowing(RegistryHandler.MANA_FLUID_PROPERTIES));

    //public static final ForgeFlowingFluid.Properties MANA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(() -> MANA_FLUID.get(), () -> MANA_FLOWING.get(), FluidAttributes.builder(new ResourceLocation(ManaPlus.MOD_ID, "blocks/mana_still"), new ResourceLocation(ManaPlus.MOD_ID, "blocks/mana_flowing")).luminosity(5).density(5).sound(SoundEvents.BLOCK_WATER_AMBIENT)).block(() -> RegistryHandler.MANA_BLOCK.get());
    //Biomes
    //public static final RegistryObject<Biome> FLOWER_PLAINS = BIOMES.register("flower_plains", () -> Biome.Builder.create(new ResourceLocation("mana-plus", "worldgen/biome/flower_plains_biome")));
}
